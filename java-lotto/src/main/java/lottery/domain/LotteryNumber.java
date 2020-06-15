package lottery.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LotteryNumber {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private static final Map<Integer, LotteryNumber> lotteryNumberCache = new HashMap<>();

    static {
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            lotteryNumberCache.put(i, new LotteryNumber(i));
        }
    }

    private final int lotteryNumber;

    private LotteryNumber(int lotteryNumber) {
        validateLotteryNumber(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    public static LotteryNumber from(int lotteryNumber) {
        return Optional.ofNullable(lotteryNumberCache.get(lotteryNumber))
                .orElseThrow(() -> new LotteryBuildingException(LotteryBuildingException.OUT_OF_RANGE));
    }

    private void validateLotteryNumber(int lotteryNumber) {
        if (lotteryNumber < MINIMUM_NUMBER || lotteryNumber > MAXIMUM_NUMBER)
            throw new LotteryBuildingException(LotteryBuildingException.OUT_OF_RANGE);
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }
}
