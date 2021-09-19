package study.NumberBaseballGame;


public class AnswerResult {

    private final int strikeCount;
    private final int ballCount;

    public AnswerResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public void PrintResult() {
        StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(this.ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            sb.append(this.strikeCount + "스트라이크");
        }
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }
}
