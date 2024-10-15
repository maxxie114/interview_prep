import java.util.*;

// Coding Deque using two Stacks
// A deque have these operations: pushFirst, pushLast, popFirst, popLast, 
public class MakeDequeUsingTwoStacks {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MakeDequeUsingTwoStacks() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    // Push to the front of the deque
    public void pushFirst(int a) {
        s1.push(a);
    }

    // Push to the back of the deque
    public void pushLast(int a) {
        s2.push(a);
    }

    // Pop from the front of the deque
    public int popFirst() {
        // if stack one is not empty, pop from stack 1
        if (!s1.isEmpty()) {
            return s1.pop();
        }
        // if stack 1 is empty, move everything from stack 2 to stack 1, and pop the first from stack 1
        else {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            if (!s1.isEmpty()) {
                return s1.pop();
            }
        }
        return 0;
    }

    // Pop from the back of the deque
    public int popLast() {
        // if stack 2 is not empty, pop from stack 2
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        // if stack 2 is empty, move everything from stack 1 to stack 2, and pop the last from stack 2
        else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            if (!s2.isEmpty()) {
                return s2.pop();
            }
        }
        return 0;
    }

    // get the first element of the deque
    public int peekFirst() {
        // if stack one is not empty, return the top element of stack 1
        if (!s1.isEmpty()) {
            return s1.peek();
        }
        // if stack 1 is empty, move everything from stack 2 to stack 1, and return the top element of stack 1
        else {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            if (!s1.isEmpty()) {
                return s1.peek();
            }
        }
        return 0;
    }

    // get the last element of the deque
    public int peekLast() {
        // if stack 2 is not empty, return the top element of stack 2
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        // if stack 2 is empty, move everything from stack 1 to stack 2, and return the top element of stack 2
        else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            if (!s2.isEmpty()) {
                return s2.peek();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MakeDequeUsingTwoStacks deque = new MakeDequeUsingTwoStacks();
        deque.pushFirst(1);
        deque.pushFirst(2);
        deque.pushLast(3);
        deque.pushLast(4);
        System.out.println(deque.popFirst()); // 2
        System.out.println(deque.popLast()); // 4
        System.out.println(deque.peekFirst()); // 1
        System.out.println(deque.peekLast()); // 3
    }
}