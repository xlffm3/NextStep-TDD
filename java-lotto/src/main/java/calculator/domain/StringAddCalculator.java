package calculator.domain;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static CalculationResult calculate(NumbersGroup numbersGroup) {
        return new CalculationResult(numbersGroup.calculateAddSum());
    }
}
