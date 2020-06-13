package calculator.domain;

public class StringSplitter {
    private static final String BLANK_DELIMITER = " ";

    private StringSplitter() {
    }

    public static String[] split(String expression) {
        if (isNullOrEmpty(expression)) {
            throw new CalculatorBuildingException(CalculatorBuildingException.NULL_OR_EMPTY_EXPRESSION);
        }
        return expression.split(BLANK_DELIMITER);
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
