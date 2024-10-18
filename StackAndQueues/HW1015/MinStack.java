import java.util.*;

// Implementation for Leetcode 155
public class MinStack {
    ArrayDeque<Integer> stack;
    ArrayDeque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<Integer>();
        this.minStack = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        int result = stack.peek();
        return result;
    }
    
    public int getMin() {
        int result = minStack.peek();
        return result;
    }

    public static void main(String[] Args) {
        // Write out this test case:
        // ["MinStack","push","push","push","getMin","top","pop","getMin"]
        // [[],[-2],[0],[-1],[],[],[],[]]
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin()); // return -2
        System.out.println(minStack.top()); // return -1
        minStack.pop();
        System.out.println(minStack.getMin()); // return -2
    }
}
