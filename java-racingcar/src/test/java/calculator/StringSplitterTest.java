package calculator;

import calculator.domain.CalculatorBuildingException;
import calculator.domain.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSplitterTest {

    @DisplayName("입력받은 문자를 공백을 기준으로 Split함")
    @Test
    public void splitInputString() {
        String expression = "1 + 2 + 34 * 8 / 7 - 31";

        assertThat(StringSplitter.split(expression)).isEqualTo(expression.split(" "));
    }

    @DisplayName("입력받은 문자열이 null이거나 empty한 경우 예외를 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void throwExceptionWhenSplit(String expression) {
        assertThatThrownBy(() -> {
            StringSplitter.split(expression);
        }).isInstanceOf(CalculatorBuildingException.class)
                .hasMessageContaining(CalculatorBuildingException.NULL_OR_EMPTY_EXPRESSION);
    }
}
