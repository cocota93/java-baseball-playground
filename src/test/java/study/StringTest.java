package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    public void split_학습테스트_요소가_1개_이상일때() throws Exception {
        //given
        String s = "1";
        String[] expectAnswer = {"1"};

        //when
        String[] splitResult = s.split(",");

        //then
        assertThat(splitResult).isEqualTo(expectAnswer);
    }

    @Test
    public void split_학습테스트_요소가_2개_이상일때() throws Exception {
        //given
        String s = "1,2";
        String[] expectAnswer = {"1", "2"};

        //when
        String[] splitResult = s.split(",");

        //then
        assertThat(splitResult).isEqualTo(expectAnswer);
    }

    @Test
    public void substring을이용하여_문자열가공() throws Exception {
        //given
        String s = "(1,2)";
        String expectAnswer = "1,2";

        //when
        String answer = s.substring(1, 4);

        //then
        assertThat(answer).isEqualTo(expectAnswer);
    }

    /**
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다. String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올
     * 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다. JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를
     * 드러낸다.
     */
    @Test
    public void charat학습테스트() throws Exception {
        //given
        String s = "abc";
        char expectAnswer = 'b';

        //when
        char answer = s.charAt(1);

        //then
        assertThat(answer).isEqualTo(expectAnswer);
    }

    @Test
    public void charat_학습테스트_outofindex() {
        //given
        String s = "abc";

        //when
        //then
        assertThatThrownBy(() -> {
            char answer = s.charAt(s.length() + 100);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        ;
    }
}
