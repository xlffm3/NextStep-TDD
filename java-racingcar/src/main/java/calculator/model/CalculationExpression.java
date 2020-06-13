package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculationExpression {
    private static final int MINIMUM_TOKEN_COUNTS = 2;
    private static final int ZERO = 0;

    private final List<String> calculationExpressionTokens;

    private CalculationExpression(List<String> calculationExpressionTokens) {
        this.calculationExpressionTokens = calculationExpressionTokens;
    }

    public static CalculationExpression of(String inputCalculationExpression) {
        String[] calculationExpressionTokens = StringSplitter.split(inputCalculationExpression);
        validateCalculationExpressionTokens(calculationExpressionTokens);
        List<String> trimCalculationExpressionTokens = trimCalculationExpressionTokens(calculationExpressionTokens);
        return new CalculationExpression(trimCalculationExpressionTokens);
    }

    private static void validateCalculationExpressionTokens(String[] calculationExpressionTokens) {
        int tokenCounts = calculationExpressionTokens.length;
        if (tokenCounts < MINIMUM_TOKEN_COUNTS || isEvenTokenCounts(tokenCounts)) {
            throw new CalculatorBuildingException(CalculatorBuildingException.INVALID_EXPRESSION_TOKEN_COUNTS);
        }
    }

    private static boolean isEvenTokenCounts(int tokenCounts) {
        return tokenCounts % MINIMUM_TOKEN_COUNTS == ZERO;
    }

    private static List<String> trimCalculationExpressionTokens(String[] calculationExpressionTokens) {
        return Arrays.stream(calculationExpressionTokens)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
