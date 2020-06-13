package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("문자열 Comma를 통한 Split")
    @Test
    public void splitStringByComma() {
        String firstString = "1,2";
        String secondString = "1";

        assertThat(firstString.split(",")).containsExactly("1", "2");
        assertThat(secondString.split(",")).isEqualTo(new String[]{"1"});
    }

    @DisplayName("문자열을 Substring한 뒤 Comma를 통한 Split")
    @Test
    public void substringAndSplitStringByComma() {
        String string = "(1,2)";

        String[] stringTokens = string.substring(1, 4).split(",");

        assertThat(stringTokens).containsExactly("1", "2");
    }

    @DisplayName("charAt을 통한 특정 인덱스의 문자 정상 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    public void charAtTest(int index) {
        String string = "abc";

        assertThat(string.charAt(index)).isEqualTo(string.toCharArray()[index]);
    }

    @DisplayName("charAt을 사용시 인덱스를 넘어가면 예외 발생")
    @Test
    public void throwExceptionWhenIndexOutOfBound() {
        String string = "abc";

        assertThatThrownBy(() -> {
            string.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
