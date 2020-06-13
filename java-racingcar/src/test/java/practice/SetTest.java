package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    private static Stream<Arguments> mockNumbersBuilder() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false)
        );
    }

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 Size를 확인")
    @Test
    public void getSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set에 포함된 값을 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void getSetElement(int number) {
        assertThat(numbers.contains(number)).isEqualTo(true);
    }

    @DisplayName("Set에 포함된 값과 아닌 값을 분별")
    @ParameterizedTest
    @MethodSource("mockNumbersBuilder")
    public void getSetElementWithMoreTestCase(int number, boolean isContainingNumber) {
        assertThat(numbers.contains(number)).isEqualTo(isContainingNumber);
    }
}
