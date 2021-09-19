package study.NumberBaseballGame;

import org.junit.jupiter.api.Test;

public class NumberBaseballGame {


    public void simulate() throws Exception {
        Enemy enemy = new Enemy();
        enemy.registAnswer("123");

        System.out.println("숫자를 입력해 주세요");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
        AnswerResult answerResult = enemy.checkAnswer("124");
        answerResult.PrintResult();

        if (answerResult.isAllStrike()) {
            System.out.println("게임 종료");
        }
    }

    @Test
    public void simpleSimul() throws Exception {
        //given
        simulate();
        //when

        //then
    }

}
