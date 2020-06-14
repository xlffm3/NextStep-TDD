package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.MovingStrategy;
import racing.domain.RacingGameBuildingException;
import racing.domain.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("객체 정상 생성 테스트")
    @Test
    public void makeCarObject() {
        assertThatCode(() -> {
            Car.of("test", new RandomMovingStrategy());
        }).doesNotThrowAnyException();
    }

    @DisplayName("객체 생성 실패 테스트(이름이 null이거나 빈 문자이거나 5글자를 초과한 경우)")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"123456", "99999999"})
    public void makeCarObject(String carName) {
        assertThatThrownBy(() -> {
            Car.of(carName, new RandomMovingStrategy());
        }).isInstanceOf(RacingGameBuildingException.class)
                .hasMessageContaining(RacingGameBuildingException.INVALID_CAR_NAME);
    }

    @DisplayName("항상 움직이는 전략일 경우 Move가 1씩 이동함")
    @Test
    public void moveCarAlways() {
        MovingStrategy movingStrategy = () -> true;
        Car car = Car.of("test", movingStrategy);

        car.move();
        car.move();

        assertThat(car.getPositionIndex()).isEqualTo(2);
    }

    @DisplayName("항상 움직이지 않는 전략은 자동차가 절대 움직이지 않음")
    @Test
    public void neverMoveCar() {
        MovingStrategy movingStrategy = () -> false;
        Car car = Car.of("test", movingStrategy);

        car.move();
        car.move();

        assertThat(car.getPositionIndex()).isEqualTo(0);
    }
}
