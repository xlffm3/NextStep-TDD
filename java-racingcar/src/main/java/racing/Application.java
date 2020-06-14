package racing;

import racing.domain.CarsGroup;
import racing.domain.MovingStrategy;
import racing.domain.RacingGame;
import racing.domain.RandomMovingStrategy;
import racing.view.InputView;
import racing.view.OutputView;

public class Application {

    public static void main(String[] args) {
        MovingStrategy movingStrategy = new RandomMovingStrategy();
        CarsGroup carsGroup = CarsGroup.of(InputView.inputCarNames(), movingStrategy);
        RacingGame racingGame = new RacingGame(InputView.inputGameTryCounts());
        OutputView.printGameResultHeader();
        while (racingGame.isHavingNextRound()) {
            racingGame.play(carsGroup);
            OutputView.printGameResult(carsGroup);
        }
        OutputView.printWinnerCarNames(carsGroup);
    }
}
