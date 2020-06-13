package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> (x + y)),
    MINUS("-", (x, y) -> (x - y)),
    MULTIPLE("*", (x, y) -> (x * y)),
    DIVIDE("/", (x, y) -> (x / y));

    private String operatorSign;
    private BiFunction<Integer, Integer, Integer> expression;

    private Operator(String operatorSign, BiFunction<Integer, Integer, Integer> expression) {
        this.operatorSign = operatorSign;
        this.expression = expression;
    }

    public static Operator findOperator(String operatorSign) {
        return Arrays.stream(values())
                .filter(operator -> operator.operatorSign.equals(operatorSign))
                .findAny()
                .orElseThrow(CalculatorBuildingException::new);
    }

    public int calculate(int firstNumber, int secondNumber) {
        return expression.apply(firstNumber, secondNumber);
    }
}
