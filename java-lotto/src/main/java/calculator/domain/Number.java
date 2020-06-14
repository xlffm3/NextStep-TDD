package calculator.domain;

public class Number {
    private static final int ZERO = 0;

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            validateNumber(parsedNumber);
            return new Number(parsedNumber);
        } catch (NumberFormatException e) {
            throw new CalculatorBuildingException(CalculatorBuildingException.INVALID_NUMBER_FORMAT);
        }
    }

    private static void validateNumber(int parsedNumber) {
        if (parsedNumber < ZERO) {
            throw new NumberFormatException();
        }
    }

    public int getNumber() {
        return number;
    }
}
