package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class Calculator {
    public int add(int left, int right) {
        return left + right;
    }

    public int add(String left, String right) {
        return Integer.parseInt(left) + Integer.parseInt(right);
    }

    public int minus(int left, int right) {
        return left - right;
    }
    public int minus(String left, String right) {
        return Integer.parseInt(left) - Integer.parseInt(right);
    }


    public int mul(int left, int right) {
        return left * right;
    }

    public int mul(String left, String right) {
        return Integer.parseInt(left) * Integer.parseInt(right);
    }

    public int div(int left, int right) {
        return left / right;
    }

    public int div(String left, String right) {
        return Integer.parseInt(left) / Integer.parseInt(right);
    }

    public boolean isOperator(String input){
        if(input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) return true;

        return false;
    }

    public int freeCal(String input) {
        String[] split = input.split(" ");

        //when

        Stack<String> stack = new Stack<>();
        for (String s : split) {

            if(isOperator(s)){
                stack.push(s);
                continue;
            }

            if(stack.isEmpty()){
                stack.push(s);
                continue;
            }

            int tempResult = 0;
            String operator = stack.pop();
            String first = stack.pop();
            switch (operator){
                case "+" : tempResult = add(first, s); break;
                case "-" : tempResult = minus(first, s); break;
                case "*" : tempResult = mul(first, s); break;
                case "/" : tempResult = div(first, s); break;
            }

            stack.push(String.valueOf(tempResult));
        }

        int result = Integer.parseInt(stack.pop()) ;
        return result;

    }

    @Test
    public void testFreeString() throws Exception{
        String input = "2 + 3 * 4 / 2";
        assertThat(freeCal(input)).isEqualTo(10);
    }
}
