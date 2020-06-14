package calculator.view;

import calculator.domain.CalculationResult;

public class OutputView {

    private OutputView() {
    }

    public static void printCalculationResult(CalculationResult calculationResult) {
        System.out.println(calculationResult.getCalculationResult());
    }
}
