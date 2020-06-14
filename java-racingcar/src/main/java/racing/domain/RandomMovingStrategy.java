package racing.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_BOUNDARY = 10;
    private static final int MINIMUM_MOVABLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        int randomNumber = generateRandomNumber();
        return randomNumber >= MINIMUM_MOVABLE_NUMBER;
    }

    private int generateRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUNDARY);
    }
}
