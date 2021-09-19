package study.NumberBaseballGame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class Enemy {

    private String answer;

    public void registAnswer(String registAnser) throws Exception {
        checkAnswerValid(registAnser);

        this.answer = registAnser;
    }

    private void checkAnswerValid(String answer) {
        if (StringUtils.isBlank(answer)) {
            throw new NullPointerException();
        }
        if (!answer.matches("[0-9]{3,3}")) {
            throw new InputMismatchException();
        }
        if (hasOverlapNumber(answer)) {
            throw new InputMismatchException();
        }
    }

    private boolean hasOverlapNumber(String answer) {
        Set<Integer> set = new HashSet<>();
        String[] split = answer.split("");
        for (String s : split) {
            set.add(Integer.parseInt(s));
        }

        return set.size() != split.length;
    }

    @Test
    @DisplayName("set에 중복되는 숫자 넣을경우")
    public void setOverlapNumber() throws Exception {
        //given
        Set<Integer> set = new HashSet<>();
        int addSize = 3;

        for (int i = 0; i < addSize; i++) {
            set.add(1);
        }

        for (Integer integer : set) {
            System.out.println("integer = " + integer);
        }
        assertEquals(set.size(), 1);
        //when

        //then
    }


    @Test
    public void registNullAnswer() throws Exception {
        assertThatThrownBy(() -> registAnswer(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void registZeroStringAnswer() throws Exception {
        assertThatThrownBy(() -> registAnswer("")).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void registTooLongAnswer() throws Exception {
        assertThatThrownBy(() -> registAnswer("123432432")).isInstanceOf(
            InputMismatchException.class);
    }

    @Test
    public void registTooShortAnswer() throws Exception {
        assertThatThrownBy(() -> registAnswer("12")).isInstanceOf(InputMismatchException.class);
    }

    @Test
    public void registNotNumberAnswer() throws Exception {
        assertThatThrownBy(() -> registAnswer("12f")).isInstanceOf(InputMismatchException.class);
    }

    @Test
    public void registOverlapNumberAnswer() throws Exception {
        //given
        assertThatThrownBy(() -> registAnswer("121")).isInstanceOf(InputMismatchException.class);
        //when

        //then
    }


    public AnswerResult checkAnswer(String tryAnswer) throws Exception {
        checkAnswerValid(tryAnswer);
        int strike = checkStrikeCount(tryAnswer);
        int ball = checkBallCount(tryAnswer);

        return new AnswerResult(strike, ball);
    }

    private int checkStrikeCount(String tryAnswer) throws Exception {
        long strikeCount = IntStream.range(0, tryAnswer.length())
            .filter(i -> this.answer.charAt(i) == tryAnswer.charAt(i))
            .count();
        return (int) strikeCount;
    }

    @Test
    public void check3Strike() throws Exception {
        //given
        registAnswer("123");
        //when
        int strikeCount = checkStrikeCount("123");

        //then
        assertEquals(3, strikeCount);
    }

    @Test
    public void check2Strike() throws Exception {
        //given
        registAnswer("124");
        //when
        int strikeCount = checkStrikeCount("123");

        //then
        assertEquals(2, strikeCount);
    }

    @Test
    public void check1Strike() throws Exception {
        //given
        registAnswer("168");
        //when
        int strikeCount = checkStrikeCount("123");

        //then
        assertEquals(1, strikeCount);
    }

    @Test
    public void check0Strike() throws Exception {
        //given
        registAnswer("568");
        //when
        int strikeCount = checkStrikeCount("123");

        //then
        assertEquals(0, strikeCount);
    }

    private int checkBallCount(String tryAnswer) {
        long ballCount = IntStream.range(0, tryAnswer.length())
            .filter(i -> this.answer.charAt(i) != tryAnswer.charAt(i))
            .filter(i -> {
                char checkNum = this.answer.charAt(i);
                return tryAnswer.indexOf(checkNum) != -1;
            })
            .count();
        return (int) ballCount;
    }

    @Test
    public void check3Ball() throws Exception {
        //given
        registAnswer("123");
        //when
        int strikeCount = checkBallCount("312");

        //then
        assertEquals(3, strikeCount);
    }

    @Test
    public void check2Ball() throws Exception {
        //given
        registAnswer("124");
        //when
        int strikeCount = checkBallCount("214");

        //then
        assertEquals(2, strikeCount);
    }

    @Test
    public void check1Ball() throws Exception {
        //given
        registAnswer("168");
        //when
        int strikeCount = checkBallCount("634");

        //then
        assertEquals(1, strikeCount);
    }

    @Test
    public void check0Ball() throws Exception {
        //given
        registAnswer("568");
        //when
        int strikeCount = checkStrikeCount("123");

        //then
        assertEquals(0, strikeCount);
    }

    @Test
    public void checkNullAnswer() throws Exception {
        assertThatThrownBy(() -> checkAnswer(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void checkZeroStringAnswer() throws Exception {
        assertThatThrownBy(() -> checkAnswer("")).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void checkTooLongAnswer() throws Exception {
        assertThatThrownBy(() -> checkAnswer("123432432")).isInstanceOf(
            InputMismatchException.class);
    }

    @Test
    public void checkTooShortAnswer() throws Exception {
        assertThatThrownBy(() -> checkAnswer("12")).isInstanceOf(InputMismatchException.class);
    }

    @Test
    public void checkNotNumberAnswer() throws Exception {
        assertThatThrownBy(() -> checkAnswer("12f")).isInstanceOf(InputMismatchException.class);
    }


}
