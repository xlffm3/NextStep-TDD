package calculator.domain;

public class StringCalculator {
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int TWO = 2;

    private StringCalculator() {
    }

    public static CalculationResult calculate(CalculationExpression calculationExpression) {
        int calculationExpressionLength = calculationExpression.getLength();
        int firstNumber = calculationExpression.getNumberByIndex(INDEX_ZERO);
        for (int i = INDEX_ONE; i < calculationExpressionLength; i += TWO) {
            Operator operator = calculationExpression.getMatchOperatorByIndex(i);
            int secondNumber = calculationExpression.getNumberByIndex(i + INDEX_ONE);
            firstNumber = operator.calculate(firstNumber, secondNumber);
        }
        return new CalculationResult(firstNumber);
    }
}
