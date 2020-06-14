package calculator;

import calculator.domain.CalculationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationResultTest {

    @DisplayName("객체 생성 및 인스턴스 변수 확인 테스트")
    @Test
    public void makeCalculationResult() {
        CalculationResult calculationResult = new CalculationResult(33);

        assertThat(calculationResult.getCalculationResult()).isEqualTo(33);
    }
}
