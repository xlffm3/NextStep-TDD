package racing.domain;

public class Car {
    private static final int DEFAULT_POSITION_INDEX = 0;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private final MovingStrategy movingStrategy;
    private int positionIndex;

    private Car(String name, MovingStrategy movingStrategy) {
        this.name = name;
        this.positionIndex = DEFAULT_POSITION_INDEX;
        this.movingStrategy = movingStrategy;
    }

    public static Car of(String name, MovingStrategy movingStrategy) {
        validateName(name);
        return new Car(name, movingStrategy);
    }

    private static void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new RacingGameBuildingException(RacingGameBuildingException.INVALID_CAR_NAME);
        }
    }

    public void move() {
        if (movingStrategy.isMovable()) {
            positionIndex++;
        }
    }

    public int getPositionIndex() {
        return positionIndex;
    }

    public String getName() {
        return name;
    }
}
