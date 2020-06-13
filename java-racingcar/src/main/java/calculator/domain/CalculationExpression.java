package calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> trimCalculationExpressionTokens = trimCalculationExpressionTokens(calculationExpressionTokens);
        return new CalculationExpression(trimCalculationExpressionTokens);
    }

    private static void validateCalculationExpressionTokens(String[] calculationExpressionTokens) {
        int tokenCounts = calculationExpressionTokens.length;
        if (tokenCounts < MINIMUM_TOKEN_COUNTS || tokenCounts % TWO == ZERO) {
            throw new CalculatorBuildingException(CalculatorBuildingException.INVALID_EXPRESSION_TOKEN_COUNTS);
        }
    }

    private static List<String> trimCalculationExpressionTokens(String[] calculationExpressionTokens) {
        return Arrays.stream(calculationExpressionTokens)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<String> getTokens() {
        return Collections.unmodifiableList(calculationExpressionTokens);
    }
}
