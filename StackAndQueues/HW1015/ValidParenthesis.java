import java.util.*;

// Solution for leetcode 20
public class ValidParenthesis {
    private ArrayDeque<Character> stack;

    public ValidParenthesis() {
        this.stack = new ArrayDeque<>();
    }

    // check if the two character is a pair
    public boolean checkPair(char c, char d) {
        if ((c == '(' && d == ')') || (c == '[' && d == ']') || (c == '{' && d == '}')) {
            return true;
        }
        return false;
    }

    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(c);
            } else if (checkPair(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        // test cases
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(vp.isValid("()")); // true
        System.out.println(vp.isValid("()[]{}")); // true
        System.out.println(vp.isValid("[({})]")); // true
        System.out.println(vp.isValid("([)]")); // false
    }
}