package lottery;

import lottery.domain.LotteryRank;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTicketsGroup;
import lottery.domain.WinningLottery;
import lottery.view.ViewMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryGameTest {

    private static Stream<Arguments> mockLotteryTicketBuilder() {
        return Stream.of(
                Arguments.of("11, 22, 33, 44, 1, 2".split(ViewMessages.COMMA),
                        LotteryRank.FIRST_PRIZE, 1),
                Arguments.of("1, 2, 3, 44, 9, 8".split(ViewMessages.COMMA),
                        LotteryRank.FIFTH_PRIZE, 2)
        );
    }


    @DisplayName("LotteryGame에서 당첨 번호를 비교해 당첨된 로또 티켓들의 개수를 저장한 Map 반환")
    @ParameterizedTest
    @MethodSource("mockLotteryTicketBuilder")
    public void findLotteryWinnerTicketsGroup(String[] winnerTicket, LotteryRank lotteryRank,
                                              int winnerCounts) {
        LotteryTicket loser = LotteryTicket.publishManualLotteryTicket("1,2,3,4,5,6".split(","));
        LotteryTicket winner = LotteryTicket.publishManualLotteryTicket("11,22,33,44,1,2".split(","));
        LotteryTicketsGroup lotteryTicketsGroup = LotteryTicketsGroup.from(Arrays.asList(loser, winner));
        WinningLottery winningLottery = WinningLottery.of(winnerTicket, 45);

        Map<LotteryRank, Integer> winnerTicketsGroup = lotteryTicketsGroup
                .findWinnerTicketCountsByRank(winningLottery);

        assertThat(winnerTicketsGroup.get(lotteryRank)).isEqualTo(winnerCounts);
    }
}
