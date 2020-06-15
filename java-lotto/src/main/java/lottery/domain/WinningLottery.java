package lottery.domain;

import java.util.List;

public class WinningLottery {

    private final LotteryTicket lastWinningTicket;
    private final LotteryNumber bonusBall;

    private WinningLottery(LotteryTicket lastWinningTicket, LotteryNumber bonusBall) {
        validateLastWinningLottery(lastWinningTicket, bonusBall);
        this.lastWinningTicket = lastWinningTicket;
        this.bonusBall = bonusBall;
    }

    public static WinningLottery of(String[] lastWinningTicketNumbers, int bonusBallNumber) {
        LotteryTicket lastWinningTicket = LotteryTicket.publishManualLotteryTicket(lastWinningTicketNumbers);
        LotteryNumber bonusBall = LotteryNumber.from(bonusBallNumber);
        return new WinningLottery(lastWinningTicket, bonusBall);
    }

    private void validateLastWinningLottery(LotteryTicket lastWinningTicket, LotteryNumber bonusBallNumber) {
        if (lastWinningTicket.isContainingLotteryNumber(bonusBallNumber.getLotteryNumber())) {
            throw new LotteryBuildingException(LotteryBuildingException.INVALID_BONUS_BALL_NUMBER);
        }
    }

    public List<Integer> getLastWinningTicketNumbers() {
        return lastWinningTicket.getLotteryNumbers();
    }

    public int getBonusBallNumber() {
        return bonusBall.getLotteryNumber();
    }
}
