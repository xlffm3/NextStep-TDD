package calculator;

import calculator.domain.NumbersGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("Null이거나 Empty인 문자열 식의 결과값은 0")
    @NullAndEmptySource
    @ParameterizedTest
    public void zeroWhenNullOrEmpty(String expression) {
        NumbersGroup numbersGroup = NumbersGroup.of(expression);

        assertThat(numbersGroup.calculateAddSum()).isEqualTo(0);
    }
}
