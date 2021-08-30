package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

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

        List<String> operatorList = Arrays.stream(split)
                                          .filter(o -> isOperator(o))
                                          .collect(Collectors.toList());
        List<String> numberList = Arrays.stream(split)
                                          .filter(o -> !isOperator(o))
                                          .collect(Collectors.toList());

        //when
        Stack<String> stack = new Stack<>();
        for (String s : numberList) {
            if(stack.isEmpty()){
                stack.push(s);
                continue;
            }

            String beforeNumber = stack.pop();
            String operator = operatorList.get(0);
            operatorList.remove(0);
            int result = calByAutoSelectedOperator(beforeNumber, operator, s);
            stack.push(String.valueOf(result));
        }

        int result = Integer.parseInt(stack.pop()) ;
        return result;
    }

    private int calByAutoSelectedOperator(String left, String operator, String right) {
        int result = 0;
        switch (operator){
            case "+" : result = add(left, right); break;
            case "-" : result = minus(left, right); break;
            case "*" : result = mul(left, right); break;
            case "/" : result = div(left, right); break;
        }
        return result;
    }

    @Test
    public void testFreeString() throws Exception{
        String input = "2 + 3 * 4 / 2";
        assertThat(freeCal(input)).isEqualTo(10);
    }
}
