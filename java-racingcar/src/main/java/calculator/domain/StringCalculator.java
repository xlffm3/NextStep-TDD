package calculator.domain;

import java.util.List;

public class StringCalculator {
    private static final int INDEX_FIRST = 1;

    private StringCalculator() {
    }

    public static int calculate(CalculationExpression calculationExpression) {
        List<String> calculationExpressionTokens = calculationExpression.getTokens();
        int tokenCounts = calculationExpressionTokens.size();
        int result = 0;
        int firstNumber = Integer.parseInt(calculationExpressionTokens.get(0));
        for (int i = INDEX_FIRST; i < tokenCounts; i += 2) {
            Operator operator = Operator.findOperator(calculationExpressionTokens.get(i));
            int secondNumber = Integer.parseInt(calculationExpressionTokens.get(i + 1));
            result = operator.calculate(firstNumber, secondNumber);
            firstNumber = result;
        }
        return result;

        // 1 + 2 + 3 + 4
    }
}
