package calculator;

import calculator.domain.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    private static Stream<Arguments> mockStringBuilder() {
        return Stream.of(
                Arguments.of("//!\n1!2!3", "1!2!3".split("!")),
                Arguments.of("//k\n11k22k3", "11k22k3".split("k"))
        );
    }

    @DisplayName("기본 구분자를 이용하여 문자열을 분리한다")
    @ParameterizedTest
    @ValueSource(strings = {"1:2,3", "1:2:3", "1,2:3"})
    public void splitUsingDefaultDelimiter(String calculationExpression) {
        String[] tokens = StringSplitter.split(calculationExpression);

        assertThat(tokens).isEqualTo("1:2:3".split(":"));
    }

    @DisplayName("custom 구분자를 이용하여 문자열을 분리한다")
    @ParameterizedTest
    @MethodSource("mockStringBuilder")
    public void splitUsingCustomDelimiter(String calculationExpression, String[] expectedToken) {
        String[] tokens = StringSplitter.split(calculationExpression);

        assertThat(tokens).isEqualTo(expectedToken);
    }
}
