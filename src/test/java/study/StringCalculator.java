package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculator {
    Calculator cal;

    @BeforeEach
    public void setting () throws Exception{
        cal = new Calculator();
    }

    @Test
    public void add() throws Exception{
        assertThat(cal.add(1, 1)).isEqualTo(2);
    }

    @Test
    public void minus() throws Exception{
        assertThat(cal.minus(7, 1)).isEqualTo(6);
    }

    @Test
    public void mul() throws Exception{
        assertThat(cal.mul(7, 3)).isEqualTo(21);
    }

    @Test
    public void div() throws Exception{
        assertThat(cal.div(7, 2)).isEqualTo(3);
    }


    @Test
    public void freeInput() throws Exception{
        //given
//        cal.freeCal()
        //when

        //then
    }
}
