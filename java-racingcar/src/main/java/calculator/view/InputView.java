package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BLANK_DELIMITER = " ";

    private InputView() {
    }

    public static String inputCalculationExpression() {
        return SCANNER.nextLine();
    }
}
