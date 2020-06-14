package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.CarsGroup;
import racing.domain.RacingGame;
import racing.domain.RacingGameBuildingException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @DisplayName("객체 정상 생성")
    @Test
    public void makeRacingGameObject() {
        assertThatCode(() -> {
            new RacingGame(4);
        }).doesNotThrowAnyException();
    }

    @DisplayName("객체 생성 실패(게임 시도 회수가 1 미만인 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void makeRacingGameObject(int gameTryCounts) {
        assertThatThrownBy(() -> {
            new RacingGame(gameTryCounts);
        }).isInstanceOf(RacingGameBuildingException.class)
                .hasMessageContaining(RacingGameBuildingException.INVALID_GAME_TRY_COUNTS);
    }

    @DisplayName("더 플레이 할 수 있는 다음 회차 게임이 있는지 확인")
    @Test
    public void isHavingNextRound() {
        CarsGroup carsGroup = CarsGroup.of(Arrays.asList("1", "2", "3"), () -> true);
        RacingGame racingGame = new RacingGame(2);

        assertThat(racingGame.isHavingNextRound()).isTrue();
        racingGame.play(carsGroup);

        assertThat(racingGame.isHavingNextRound()).isTrue();
        racingGame.play(carsGroup);

        assertThat(racingGame.isHavingNextRound()).isFalse();
    }

    @DisplayName("플레이 가능한 회차가 없는데 플레이를 시도하면 예외가 발생")
    @Test
    public void throwExceptionWhenNotHavingGameTryCounts() {
        CarsGroup carsGroup = CarsGroup.of(Arrays.asList("1", "2", "3"), () -> true);
        RacingGame racingGame = new RacingGame(1);

        assertThatThrownBy(() -> {
            racingGame.play(carsGroup);
            racingGame.play(carsGroup);
        }).isInstanceOf(RacingGameBuildingException.class)
                .hasMessageContaining(RacingGameBuildingException.RUN_OUT_GAME_TRY_COUNTS);
    }
}
