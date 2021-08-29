package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    public void separator() throws Exception{
        //given
        String input = "1,2";
        //when
        String[] split = input.split(",");

        //then
        for (int i = 0; i < split.length; i++) {
            Assertions.assertEquals("" + (i + 1), split[i]);
        }
    }

    @Test
    public void separatorAlways() throws Exception{
        //given
        String input = "1";
        //when
        String[] split = input.split(",");

        //then
        Assertions.assertEquals("1", split[0]);
    }

    @Test
    public void asd() throws Exception{
        //given
        String input = "(1,2)";
        //when
        String substring = input.substring(1, input.length() - 1);

        //then
        Assertions.assertEquals("1,2",substring);
    }

    @Test
    public void asd2() throws Exception{
        //given
        String input = "ab";

        //when
        Assertions.assertEquals('a', input.charAt(0));
        Assertions.assertEquals('b', input.charAt(1));
//        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
//                    input.charAt(-1);
//                }
//        );
//
        assertThatThrownBy(() -> {
            input.charAt(2);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
//                .hasMessageContaining("index:2, Size: 2")
        ;

//        assertThat

//        assertThatIOException().isThrownBy(() -> {
//            input.charAt(-1);
//        });

//        assertThatCode(() -> {
////            input.charAt(-1);
//            input.charAt(0);
//        }).doesNotThrowAnyException();

        //then
    }
}
