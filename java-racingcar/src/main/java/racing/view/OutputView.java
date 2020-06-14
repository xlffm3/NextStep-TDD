package racing.view;

import racing.domain.CarsGroup;

import java.util.List;

public class OutputView {
    private static final int INDEX_ZERO = 0;
    private static final int STRING_BUILDER_ZERO_LENGTH = 0;

    private OutputView() {
    }

    public static void printGameResultHeader() {
        System.out.println(ViewMessages.RESULT_HEADER);
    }

    public static void printGameResult(CarsGroup carsGroup) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> carNames = carsGroup.getCarNames();
        List<Integer> carPositions = carsGroup.getCarPositions();
        int carCounts = carsGroup.getCarCounts();
        for (int i = INDEX_ZERO; i < carCounts; i++) {
            stringBuilder.append(carNames.get(i))
                    .append(ViewMessages.COLON);
            appendEachCarPosition(carPositions.get(i), stringBuilder);
        }
        System.out.println(stringBuilder.toString());
    }

    private static void appendEachCarPosition(int carPosition, StringBuilder stringBuilder) {
        for (int i = INDEX_ZERO; i < carPosition; i++) {
            stringBuilder.append(ViewMessages.DASH);
        }
        stringBuilder.append(ViewMessages.NEW_LINE);
    }

    public static void printWinnerCarNames(CarsGroup carsGroup) {
        List<String> winnerCarNames = carsGroup.getWinnerCarNames();
        StringBuilder stringBuilder = new StringBuilder();
        winnerCarNames.forEach(winnerCarName -> appendWinnerCarName(winnerCarName, stringBuilder));
        System.out.printf(ViewMessages.WINNER_CAR_NAMES, stringBuilder.toString());
    }

    private static void appendWinnerCarName(String winnerCarName, StringBuilder stringBuilder) {
        if (!isFirstName(stringBuilder)) {
            stringBuilder.append(ViewMessages.COMMA);
        }
        stringBuilder.append(winnerCarName);
    }

    private static boolean isFirstName(StringBuilder stringBuilder) {
        return stringBuilder.length() == STRING_BUILDER_ZERO_LENGTH;
    }
}
