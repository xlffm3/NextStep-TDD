package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.CarsGroup;
import racing.domain.RandomMovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarsGroupTest {

    @DisplayName("carsGroup 객체 정상 생성 테스트")
    @Test
    public void makeCarsGroup() {
        List<String> carNames = Arrays.asList("1", "2", "3");

        assertThatCode(() -> {
            CarsGroup.of(carNames, new RandomMovingStrategy());
        }).doesNotThrowAnyException();
    }

    @DisplayName("모든 Car 객체의 String 이름 반환")
    @Test
    public void getCarNames() {
        List<String> carNames = Arrays.asList("1", "2", "3");
        CarsGroup carsGroup = CarsGroup.of(carNames, () -> true);

        assertThat(carsGroup.getCarNames()).isEqualTo(carNames);
    }

    @DisplayName("move 요청시 모든 Car 객체들에게 move 요청을 진행함.")
    @Test
    public void moveAllCars() {
        List<String> carNames = Arrays.asList("1", "2", "3");
        CarsGroup carsGroup = CarsGroup.of(carNames, () -> true);

        carsGroup.move();

        assertThat(carsGroup.getCarPositions()).isEqualTo(Arrays.asList(1, 1, 1));
    }

    @DisplayName("가장 멀리 이동한 자동차들의 명단을 받는 테스트")
    @Test
    public void getWinnerCarNames() {
        List<String> carNames = Arrays.asList("1", "2", "3");
        CarsGroup carsGroup = CarsGroup.of(carNames, () -> true);

        carsGroup.move();

        assertThat(carsGroup.getWinnerCarNames()).isEqualTo(Arrays.asList("1", "2", "3"));
    }
}
