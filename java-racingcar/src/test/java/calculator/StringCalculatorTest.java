package calculator;

import calculator.domain.CalculationExpression;
import calculator.domain.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private static Stream<Arguments> mockExpressionBuilder() {
        return Stream.of(
                Arguments.of("1 + 10 + 9 / 2 * 8 - 5", 75),
                Arguments.of("1 + 9 * 9 / 10 - 10", -1)
        );
    }

    @DisplayName("사칙연산 기호가 모두 들어간 계산식 테스트")
    @ParameterizedTest
    @MethodSource("mockExpressionBuilder")
    public void calculateUsingAllOperator(String expression, int expectedResult) {
        CalculationExpression calculationExpression = CalculationExpression.of(expression);

        int result = StringCalculator.calculate(calculationExpression);

        assertThat(result).isEqualTo(expectedResult);
    }
}
