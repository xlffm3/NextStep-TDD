package calculator;

import calculator.domain.CalculationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationResultTest {

    @DisplayName("객체 생성 및 내부 값 확인")
    @Test
    public void makeCalculationResult() {
        CalculationResult calculationResult = new CalculationResult(10);

        assertThat(calculationResult.getCalculationResult()).isEqualTo(10);
    }
}
