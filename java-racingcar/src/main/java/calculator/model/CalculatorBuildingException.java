package calculator.model;

public class CalculatorBuildingException extends RuntimeException {
    public static final String NULL_OR_EMPTY_EXPRESSION = "계산식 문자열이 null이거나 비어있습니다.";
    public static final String INVALID_EXPRESSION_TOKEN_COUNTS = "계산식 구성 요소의 개수가 1이거나 짝수일 수 없습니다.";

    public CalculatorBuildingException() {
        super();
    }

    public CalculatorBuildingException(String message) {
        super(message);
    }
}
