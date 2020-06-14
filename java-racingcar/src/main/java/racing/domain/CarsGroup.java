package racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarsGroup {

    private final List<Car> cars;

    private CarsGroup(List<Car> cars) {
        this.cars = cars;
    }

    public static CarsGroup of(List<String> carNames, MovingStrategy movingStrategy) {
        List<Car> cars = carNames.stream()
                .map(carName -> Car.of(carName, movingStrategy))
                .collect(Collectors.toList());
        return new CarsGroup(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPositionIndex)
                .collect(Collectors.toList());
    }

    public int getCarCounts() {
        return cars.size();
    }

    public List<String> getWinnerCarNames() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPositionIndex() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        Car maxPositionCar = cars.stream()
                .max(Comparator.comparing(Car::getPositionIndex))
                .orElseThrow(RacingGameBuildingException::new);
        return maxPositionCar.getPositionIndex();
    }
}
