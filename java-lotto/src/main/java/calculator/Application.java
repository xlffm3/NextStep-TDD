package calculator;

import calculator.domain.CalculationResult;
import calculator.domain.NumbersGroup;
import calculator.domain.StringAddCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        NumbersGroup numbersGroup = NumbersGroup.of(InputView.inputCalculationExpression());
        CalculationResult calculationResult = StringAddCalculator.calculate(numbersGroup);
        OutputView.printCalculationResult(calculationResult);
    }
}
