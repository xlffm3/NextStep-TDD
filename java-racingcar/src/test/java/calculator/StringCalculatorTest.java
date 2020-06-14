package calculator;

import calculator.domain.CalculationExpression;
import calculator.domain.CalculationResult;
import calculator.domain.CalculatorBuildingException;
import calculator.domain.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private static Stream<Arguments> mockExpressionBuilder() {
        return Stream.of(
                Arguments.of("1 + 10 + 9 / 2 * 8 - 5", 75),
                Arguments.of("1 + 9 * 9 / 10 - 10", -1),
                Arguments.of("1 * 2 * 3 + 4 / 5 - 6", -4),
                Arguments.of("1 * 3 * 10 / 5 - 1 + 10", 15),
                Arguments.of("9 + 9 / 9 * 9 - 9", 9),
                Arguments.of("3 * 2 * 2 / 2 - 1 + 3", 8)
        );
    }

    @DisplayName("사칙연산 기호가 모두 들어간 계산식 테스트")
    @ParameterizedTest
    @MethodSource("mockExpressionBuilder")
    public void calculateUsingAllOperator(String expression, int expectedResult) {
        CalculationExpression calculationExpression = CalculationExpression.of(expression);

        CalculationResult result = StringCalculator.calculate(calculationExpression);

        assertThat(result.getCalculationResult()).isEqualTo(expectedResult);
    }

    @DisplayName("숫자 자리에 숫자가 아닌 문자열이 존재하면 예외 발생")
    @Test
    public void throwExceptionWhenInvalidNumber() {
        String expression = "1 + 3 - ! * 15";
        CalculationExpression calculationExpression = CalculationExpression.of(expression);

        assertThatThrownBy(() -> {
            StringCalculator.calculate(calculationExpression);
        }).isInstanceOf(CalculatorBuildingException.class);
    }

    @DisplayName("연산자 자리에 연산자가 아닌 다른 문자열이 존재하면 예외 발생")
    @Test
    public void throwExceptionWhenInvalidOperator() {
        String expression = "1 + 3 - 19 k 15";
        CalculationExpression calculationExpression = CalculationExpression.of(expression);

        assertThatThrownBy(() -> {
            StringCalculator.calculate(calculationExpression);
        }).isInstanceOf(CalculatorBuildingException.class);
    }
}
