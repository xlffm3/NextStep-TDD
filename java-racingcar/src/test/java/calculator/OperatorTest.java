package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    private static Stream<Arguments> mockOperatorBuilder() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("*", Operator.MULTIPLE)
        );
    }

    @DisplayName("10 + 25 연산자 값 테스트")
    @Test
    public void calculatePlus() {
        int first = 10;
        int second = 25;

        assertThat(Operator.PLUS.calculate(first, second)).isEqualTo(35);
    }

    @DisplayName("33 / 10 연산자 값 테스트")
    @Test
    public void calculateDivide() {
        int first = 33;
        int second = 10;

        assertThat(Operator.DIVIDE.calculate(first, second)).isEqualTo(3);
    }

    @DisplayName("연산자 기호 String을 통해 적합한 Operator을 반환하는 테스트")
    @ParameterizedTest
    @MethodSource("mockOperatorBuilder")
    public void valueOfTest(String operatorSign, Operator operator) {
        assertThat(Operator.findOperator(operatorSign)).isEqualTo(operator);
    }
}
