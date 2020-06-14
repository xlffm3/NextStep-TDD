package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (firstNumber, secondNumber) -> (firstNumber + secondNumber)),
    MINUS("-", (firstNumber, secondNumber) -> (firstNumber - secondNumber)),
    MULTIPLE("*", (firstNumber, secondNumber) -> (firstNumber * secondNumber)),
    DIVIDE("/", (firstNumber, secondNumber) -> (firstNumber / secondNumber));

    private final String operatorSign;
    private final BiFunction<Integer, Integer, Integer> expression;

    private Operator(String operatorSign, BiFunction<Integer, Integer, Integer> expression) {
        this.operatorSign = operatorSign;
        this.expression = expression;
    }

    public static Operator findOperator(String operatorSign) {
        return Arrays.stream(values())
                .filter(operator -> operator.operatorSign.equals(operatorSign))
                .findAny()
                .orElseThrow(() -> new CalculatorBuildingException(CalculatorBuildingException.INVALID_OPERATOR));
    }

    public int calculate(int firstNumber, int secondNumber) {
        return expression.apply(firstNumber, secondNumber);
    }
}
