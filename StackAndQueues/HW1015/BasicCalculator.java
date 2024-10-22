import java.util.*;

// Solution for leetcode 224
public class BasicCalculator {
    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int currentResult = 0;
        int sign = 1;
        int index = 0;

        while (index < s.length()) {
            // get current char at index
            char currentChar = s.charAt(index);

            // if current char is a digit
            if (Character.isDigit(currentChar)) {
                int num = 0;
                while (index < s.length() && Character.isDigit(currentChar)) {
                    num = num * 10 + (currentChar - '0');
                    index++;
                    if (index < s.length()) {
                        currentChar = s.charAt(index);
                    }
                }
                index--;
                currentResult += sign * num;
                
            } else if (currentChar == '+') {
                sign = 1;
            } else if (currentChar == '-') {
                sign = -1;
            } else if (currentChar == '(') {
                stack.push(currentResult);
                stack.push(sign);
                currentResult = 0;
                sign = 1;
            } else if (currentChar == ')') {
                int resultInParentheses = currentResult;
                resultInParentheses *= stack.pop();
                resultInParentheses += stack.pop();
                currentResult = resultInParentheses;
            }
            index++;
        }
        return currentResult;
    }

    public static void main(String[] Args) {
        // test case
        BasicCalculator bc = new BasicCalculator();
        System.out.println(bc.calculate("1 + 1")); // 2
        System.out.println(bc.calculate(" 2-1 + 2 ")); // 3
        System.out.println(bc.calculate("(1+(4+5+2)-3)+(6+8)")); // 23
    }
}
