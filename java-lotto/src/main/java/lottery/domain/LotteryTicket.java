package lottery.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LotteryTicket {
    private static final int LOTTERY_NUMBER_COUNTS = 6;

    private final List<LotteryNumber> lotteryNumbers;

    private LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        validateLotteryNumberCounts(lotteryNumbers);
        validateLotteryNumbersDuplication(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    public static LotteryTicket from(List<LotteryNumber> lotteryNumbers) {
        return new LotteryTicket(lotteryNumbers);
    }

    public static LotteryTicket publishManualLotteryTicket(String[] lotteryNumbers) {
        List<LotteryNumber> parsedLotteryNumbers = Arrays.stream(lotteryNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LotteryNumber::from)
                .collect(Collectors.toList());
        return new LotteryTicket(parsedLotteryNumbers);
    }

    public static LotteryTicket publishAutomaticLotteryTicket() {
        return new LotteryTicket(LotteryNumbersGenerator.generateAutomaticNumbers());
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers.stream()
                .map(LotteryNumber::getLotteryNumber)
                .collect(Collectors.toList());
    }

    public boolean isContainingLotteryNumber(int lotteryNumber) {
        return getLotteryNumbers().contains(lotteryNumber);
    }

    private void validateLotteryNumberCounts(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_NUMBER_COUNTS) {
            throw new LotteryBuildingException(LotteryBuildingException.INVALID_NUMBER_COUNTS);
        }
    }

    private void validateLotteryNumbersDuplication(List<LotteryNumber> lotteryNumbers) {
        long filteredLotteryNumberCounts = lotteryNumbers.stream()
                .map(LotteryNumber::getLotteryNumber)
                .distinct()
                .count();
        if (lotteryNumbers.size() != filteredLotteryNumberCounts) {
            throw new LotteryBuildingException(LotteryBuildingException.DUPLICATED_NUMBER);
        }
    }

    public LotteryRank getMatchLotteryRank(WinningLottery winningLottery) {
        long matchNumberCounts = getLotteryNumbers().stream()
                .filter(targetNumber ->
                        winningLottery.getLastWinningTicketNumbersStream().anyMatch(Predicate.isEqual(targetNumber)))
                .count();
        int bonusBallCount = getContainingBonusBallCount(winningLottery);
        return LotteryRank.valueOf((int) matchNumberCounts, bonusBallCount);
    }

    private int getContainingBonusBallCount(WinningLottery winningLottery) {
        int bonusBallNumber = winningLottery.getBonusBallNumber();
        return (int) getLotteryNumbers().stream()
                .filter(targetNumber -> targetNumber == bonusBallNumber)
                .count();
    }
}
