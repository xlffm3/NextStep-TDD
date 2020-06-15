package lottery.domain;

import java.util.List;
import java.util.stream.Stream;

public class ManualTicketsNumbers {

    private final List<String[]> manualTicketsNumbers;

    public ManualTicketsNumbers(List<String[]> manualTicketsNumbers) {
        this.manualTicketsNumbers = manualTicketsNumbers;
    }

    public Stream<LotteryTicket> getManualTicketsStream() {
        return manualTicketsNumbers.stream()
                .map(LotteryTicket::publishManualLotteryTicket);
    }
}
