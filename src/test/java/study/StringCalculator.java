package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringCalculator {


    @Test
    public void asd() throws Exception {
        String input = "2 + 3 * 4 / 2";
        Integer expectAnswer = 10;
        ByteArrayInputStream nextIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(nextIn);

        String s = scanner.nextLine();
        String[] s1 = s.split(" ");

        List<Integer> extractedNumber = extractNumber(s1);
        List<String> extractedOperator = extractOperator(s1);

        Integer result = extractedNumber.get(0);
        for (int i = 0; i < extractedOperator.size(); ++i) {
            String operator = extractedOperator.get(i);
            Integer targetNum = extractedNumber.get(i + 1);
            result = calculateBySingleOperator(operator, result, targetNum);
        }

        assertThat(result).isEqualTo(expectAnswer);
    }

    private Integer calculateBySingleOperator(String operator, Integer result, Integer targetNum) {
        if ("+".equals(operator)) {
            return result + targetNum;
        }
        if ("-".equals(operator)) {
            return result - targetNum;
        }
        if ("*".equals(operator)) {
            return result * targetNum;
        }
        if ("/".equals(operator)) {
            return result / targetNum;
        }

        throw new IllegalArgumentException();
    }

    private List<Integer> extractNumber(String[] s1) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s1.length; i += 2) {
            Integer integer = Integer.valueOf(s1[i]);
            result.add(integer);
        }

        return result;
    }

    private List<String> extractOperator(String[] s1) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < s1.length; i += 2) {
            result.add(s1[i]);
        }

        return result;
    }
}
