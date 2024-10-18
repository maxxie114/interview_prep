import java.util.*;

public class MinimumRemove {
    public String minRemoveToMakeValid(String s) {
        // Stack to keep track of indices of invalid parentheses
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        // Identify all invalid parentheses, store the indexes of all the invalid parentheses in the stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!(stack.size() == 0) && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        
        // Remove all invalid parentheses from the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}
