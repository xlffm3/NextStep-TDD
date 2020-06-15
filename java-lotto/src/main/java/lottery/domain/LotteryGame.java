package lottery.domain;

import java.util.Map;

public class LotteryGame {

    private LotteryGame() {
    }

    public static LotteryGame getInstance() {
        return new LotteryGame();
    }

    public LotteryGameResult drawWinnerLotteryTickets(LotteryTicketsGroup lotteryTicketsGroup,
                                                      WinningLottery winningLottery) {
        Map<LotteryRank, Integer> gameResultBoard = lotteryTicketsGroup
                .findWinnerTicketCountsByRank(winningLottery);
        return LotteryGameResult.from(gameResultBoard);
    }
}
