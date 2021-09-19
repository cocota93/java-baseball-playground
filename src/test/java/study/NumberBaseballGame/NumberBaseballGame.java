package study.NumberBaseballGame;

import org.junit.jupiter.api.Test;

public class NumberBaseballGame {


    public void simulate() throws Exception {

        boolean simulating = true;
        do {
            Enemy enemy = new Enemy();
            enemy.registAnswer("123");

            playQuestionAndAnswer(enemy);

            simulating = askReplayGame();
        } while (simulating);
    }

    private boolean askReplayGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        return false;
    }

    private void playQuestionAndAnswer(Enemy enemy) throws Exception {
        boolean playing = true;
        do {
            System.out.println("숫자를 입력해 주세요");
            String input = "124";

            AnswerResult answerResult = enemy.checkAnswer(input);
            answerResult.PrintResult();

            playing = !answerResult.isAllStrike();
        } while (playing);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    public void simpleSimul() throws Exception {
        //given
        simulate();
        //when

        //then
    }

}
