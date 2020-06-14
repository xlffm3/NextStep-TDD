package calculator;

import calculator.domain.CalculationExpression;
import calculator.domain.CalculatorBuildingException;
import calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("객체 생성 후 Index 번호를 보내면 해당되는 Number String을 Integer로 변환함")
    @Test
    public void getIntegerNumberByIndex() {
        String expression = "1 + 4 + 10 / 9";
        CalculationExpression calculationExpression = CalculationExpression.of(expression);

        assertThat(calculationExpression.getNumberByIndex(0)).isEqualTo(1);
        assertThat(calculationExpression.getNumberByIndex(2)).isEqualTo(4);
    }

    @DisplayName("객체 생성 후 Index 번호를 보낼 때 해당되는 Number String이 숫자 형태가 아닌 경우 예외 발생")
    @Test
    public void throwExceptionWhenInvalidNumber() {
        String expression = "10 + 1? + 10 / 9";
        CalculationExpression calculationExpression = CalculationExpression.of(expression);

        assertThatThrownBy(() -> {
            calculationExpression.getNumberByIndex(2);
        }).isInstanceOf(CalculatorBuildingException.class)
                .hasMessageContaining(CalculatorBuildingException.INVALID_NUMBER_FORMAT);
    }

    @DisplayName("객체 생성 후 Index 번호를 보낼 때 해당되는 Operator String으로 Operator를 찾아 반환함")
    @Test
    public void findMatchOperator() {
        String expression = "10 * 99";
        CalculationExpression calculationExpression = CalculationExpression.of(expression);

        assertThat(calculationExpression.getMatchOperatorByIndex(1)).isEqualTo(Operator.MULTIPLE);
    }
}
