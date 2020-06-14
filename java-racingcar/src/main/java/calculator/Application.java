package calculator;

import calculator.domain.CalculationExpression;
import calculator.domain.CalculationResult;
import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        CalculationExpression calculationExpression = CalculationExpression.of(InputView.inputCalculationExpression());
        CalculationResult calculationResult = StringCalculator.calculate(calculationExpression);
        OutputView.printCalculationResult(calculationResult);
    }
}
