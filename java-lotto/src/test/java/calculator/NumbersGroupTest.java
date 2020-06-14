package calculator;

import calculator.domain.NumbersGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class NumbersGroupTest {

    @DisplayName("객체 정상 생성 테스트")
    @Test
    public void getNumbersObject() {
        String expression = "1:2:3:4,5";

        assertThatCode(() -> {
            NumbersGroup.of(expression);
        }).doesNotThrowAnyException();
    }

    @DisplayName("값들의 합을 구하는 테스트")
    @Test
    public void getNumbersAddSum() {
        String expression = "1:2:3:4,5";
        NumbersGroup numbersGroup = NumbersGroup.of(expression);

        assertThat(numbersGroup.calculateAddSum()).isEqualTo(15);
    }
}
