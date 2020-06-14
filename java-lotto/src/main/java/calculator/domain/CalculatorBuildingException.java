package calculator.domain;

public class CalculatorBuildingException extends RuntimeException {
    public static final String INVALID_NUMBER_FORMAT = "음수이거나 숫자가 아닌 문자가 섞여있습니다.";

    public CalculatorBuildingException() {
        super();
    }

    public CalculatorBuildingException(String message) {
        super(message);
    }
}
