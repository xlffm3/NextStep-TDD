package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputCarNames() {
        System.out.println(ViewMessages.INSTRUCTION_CAR_NAMES);
        String[] carNames = SCANNER.nextLine().split(ViewMessages.DELIMITER);
        return Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int inputGameTryCounts() {
        System.out.println(ViewMessages.INSTRUCTION_GAME_TRY_COUNTS);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
