package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class CalculationExpression {
    private static final int MINIMUM_TOKEN_COUNTS = 3;
    private static final int TWO = 2;
    private static final int ZERO = 0;

    private final List<String> calculationExpressionTokens;

    private CalculationExpression(List<String> calculationExpressionTokens) {
        this.calculationExpressionTokens = calculationExpressionTokens;
    }

    public static CalculationExpression of(String inputCalculationExpression) {
        String[] calculationExpressionTokens = StringSplitter.split(inputCalculationExpression);
        validateCalculationExpressionTokens(calculationExpressionTokens);
        return new CalculationExpression(Arrays.asList(calculationExpressionTokens));
    }

    private static void validateCalculationExpressionTokens(String[] calculationExpressionTokens) {
        int tokenCounts = calculationExpressionTokens.length;
        if (tokenCounts < MINIMUM_TOKEN_COUNTS || tokenCounts % TWO == ZERO) {
            throw new CalculatorBuildingException(CalculatorBuildingException.INVALID_EXPRESSION_TOKEN_COUNTS);
        }
    }

    public Operator getMatchOperatorByIndex(int index) {
        return Operator.findOperator(calculationExpressionTokens.get(index));
    }

    public int getNumberByIndex(int index) {
        try {
            return Integer.parseInt(calculationExpressionTokens.get(index));
        } catch (NumberFormatException e) {
            throw new CalculatorBuildingException(CalculatorBuildingException.INVALID_NUMBER_FORMAT);
        }
    }

    public int getLength() {
        return calculationExpressionTokens.size();
    }
}
