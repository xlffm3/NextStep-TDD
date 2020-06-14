package racing.domain;

public class RacingGame {
    private static final int MINIMUM_GAME_TRY_COUNTS = 1;

    private int gameTryCounts;

    public RacingGame(int gameTryCounts) {
        validateGameTryCounts(gameTryCounts);
        this.gameTryCounts = gameTryCounts;
    }

    private void validateGameTryCounts(int gameTryCounts) {
        if (gameTryCounts < MINIMUM_GAME_TRY_COUNTS) {
            throw new RacingGameBuildingException(RacingGameBuildingException.INVALID_GAME_TRY_COUNTS);
        }
    }

    public void play(CarsGroup carsGroup) {
        if (!isHavingNextRound()) {
            throw new RacingGameBuildingException(RacingGameBuildingException.RUN_OUT_GAME_TRY_COUNTS);
        }
        carsGroup.move();
        gameTryCounts--;
    }

    public boolean isHavingNextRound() {
        return gameTryCounts >= MINIMUM_GAME_TRY_COUNTS;
    }
}
