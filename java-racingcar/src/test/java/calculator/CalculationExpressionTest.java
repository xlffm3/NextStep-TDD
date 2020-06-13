package calculator;

import calculator.domain.CalculationExpression;
import calculator.domain.CalculatorBuildingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculationExpressionTest {

    @DisplayName("계산식 문자열 Token 개수가 1이거나 짝수이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1 * 3 +"})
    public void throwExceptionWhenExpressionInvalid(String expression) {
        assertThatThrownBy(() -> {
            CalculationExpression.of(expression);
        }).isInstanceOf(CalculatorBuildingException.class)
                .hasMessageContaining(CalculatorBuildingException.INVALID_EXPRESSION_TOKEN_COUNTS);
    }
}
