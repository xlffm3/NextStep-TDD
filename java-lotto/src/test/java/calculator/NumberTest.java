package calculator;

import calculator.domain.CalculatorBuildingException;
import calculator.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @DisplayName("객체 생성 성공(일반적인 숫자)")
    @ParameterizedTest
    @ValueSource(strings = {"0", "5", "10", "15"})
    public void makeNumberObject(String number) {
        assertThatCode(() -> {
            Number.of(number);
        }).doesNotThrowAnyException();
    }

    @DisplayName("객체 생성 실패(음수이거나 숫자가 아닌 문자인 경우)")
    @ParameterizedTest
    @ValueSource(strings = {"-30", "-99", "5x", "11a0", "1k5"})
    public void throwExceptionOnMakingNumberObject(String number) {
        assertThatThrownBy(() -> {
            Number.of(number);
        }).isInstanceOf(CalculatorBuildingException.class)
                .hasMessageContaining(CalculatorBuildingException.INVALID_NUMBER_FORMAT);
    }
}
