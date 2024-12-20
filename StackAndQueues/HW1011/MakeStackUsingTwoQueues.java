import java.util.*;

// Solution for leetcode problem 225
public class MakeStackUsingTwoQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MakeStackUsingTwoQueues() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }
    
    // Push to the stack
    public void push(int a) {
        if (q1.size() > 0) {
            int temp = q1.poll();
            q2.add(temp);
        }
        q1.add(a);
    }

    // Pop from the stack
    public int pop() {
        if (q1.size() == 0) {
            for (int i = 0; i < q2.size(); i++) {
                int temp = this.q1.poll();
                q1.add(temp);
            }
        }
        return q1.poll();
    }

    // check if stack is empty
    public Boolean empty() {
        return (q1.size() == 0 && q2.size() == 0);
    }

    // Get the top element
    public int top() {
        if (q1.size() == 0) {
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }
        if (this.empty()) {
           System.err.println("Stack is empty");
           return -1;
        }
        return q1.peek();
    }

    public static void main(String[] Args) {
        // Test the stack push
        MakeStackUsingTwoQueues stack = new MakeStackUsingTwoQueues();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }
}
