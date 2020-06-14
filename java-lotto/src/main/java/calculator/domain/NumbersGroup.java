package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersGroup {
    private static final String ZERO = "0";

    private final List<Number> numbers;

    private NumbersGroup(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static NumbersGroup of(String calculationExpression) {
        if (isNullOrEmpty(calculationExpression)) {
            return new NumbersGroup(Arrays.asList(Number.of(ZERO)));
        }
        String[] calculationExpressionTokens = StringSplitter.split(calculationExpression);
        List<Number> numbers = Arrays.stream(calculationExpressionTokens)
                .map(Number::of)
                .collect(Collectors.toList());
        return new NumbersGroup(numbers);
    }

    private static boolean isNullOrEmpty(String calculationExpression) {
        return calculationExpression == null || calculationExpression.isEmpty();
    }

    public int calculateAddSum() {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }
}
