package calculator.model;

public class CalculationBuildingException extends RuntimeException {
    public static final String NULL_OR_EMPTY_EXPRESSION = "계산식 문자열이 null이거나 비어있습니다.";

    public CalculationBuildingException() {
        super();
    }

    public CalculationBuildingException(String message) {
        super(message);
    }
}
