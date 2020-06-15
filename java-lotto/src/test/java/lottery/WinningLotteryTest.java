package lottery;

import lottery.domain.WinningLottery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLotteryTest {

    @DisplayName("객체 정상 생성 테스트")
    @Test
    public void makeLastWinningLottery() {
        assertThatCode(() -> {
            WinningLottery.of(new String[]{"1", "2", "3", "4", "5", "6"}, 7);
        }).doesNotThrowAnyException();
    }

    @DisplayName("객체 생성 실패 테스트(당첨 번호와 보너스 볼 번호의 중복)")
    @Test
    public void throwExceptionOnMakingLastWinningLottery() {
        assertThatThrownBy(() -> {
            WinningLottery.of(new String[]{"1", "2", "3", "4", "5", "6"}, 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
