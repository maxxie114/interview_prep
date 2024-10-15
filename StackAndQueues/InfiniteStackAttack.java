// Implementation for a stack balancing algorithm that balance the length of the deque implemented using two stacks
// To make it easier, this code only implements the pushFirst and pushLast methods

import java.util.Stack;

public class InfiniteStackAttack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    // Make it easier by directly initializing the two stacks
    public InfiniteStackAttack(Stack<Integer> s1, Stack<Integer> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    // Push to the front of the deque
    public void pushFirst(int a) {
        // Initialize a temp stack
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        // First check if stack 1 and stack 2 are balanced, if balanced, push to stack 1
        if ((s1.size() - s2.size()) <= 1 && (s1.size() - s2.size()) >= -1) {
            s1.push(a);
        }
        // if stack 2 and stack 1 is not balanced, use another stack to move to lower half part of the stack to the other stack
        else {
            // if stack 1 is longer, move half of the elements to stack 2
            if (s1.size() - s2.size() > 1) {
                int amountToMove = (s1.size() - s2.size()) / 2;
                int s1Size = s1.size();
                for (int i = 0; i < (s1Size - amountToMove); i++) {
                    temp.push(s1.pop());
                }
                while (!s2.isEmpty()) {
                    temp2.push(s2.pop());
                }
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                while (!temp.isEmpty()) {
                    s1.push(temp.pop());
                }
                while (!temp2.isEmpty()) {
                    s2.push(temp2.pop());
                }
                s1.push(a);
            } else if (s2.size() - s1.size() > 1) {
                // if stack 2 is longer, move half of the elements to stack 1
                int amountToMove = (s2.size() - s1.size()) / 2;
                int s2Size = s2.size();
                for (int i = 0; i < (s2Size - amountToMove); i++) {
                    temp.push(s2.pop());
                }
                while (!s1.isEmpty()) {
                    temp2.push(s1.pop());
                }
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                while (!temp.isEmpty()) {
                    s2.push(temp.pop());
                }
                while (!temp2.isEmpty()) {
                    s1.push(temp2.pop());
                }
                s1.push(a);
            } 
        }
    }

    // Push to the back of the deque
    public void pushLast(int a) {
        // Initialize a temp stack
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        // First check if stack 1 and stack 2 are balanced, if balanced, push to stack 2
        if ((s2.size() - s1.size()) <= 1 && (s2.size() - s1.size()) >= -1) {
            s2.push(a);
        }
        // if stack 1 and stack 2 are not balanced, use another stack to move to lower half part of the stack to the other stack
        else {
            // if stack 2 is longer, move half of the elements to stack 1
            if (s2.size() - s1.size() > 1) {
                int amountToMove = (s2.size() - s1.size()) / 2;
                int s2Size = s2.size();
                for (int i = 0; i < (s2Size - amountToMove); i++) {
                    temp.push(s2.pop());
                }
                while (!s1.isEmpty()) {
                    temp2.push(s1.pop());
                }
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                while (!temp.isEmpty()) {
                    s2.push(temp.pop());
                }
                while (!temp2.isEmpty()) {
                    s1.push(temp2.pop());
                }
                s2.push(a);
            } else if (s1.size() - s2.size() > 1) {
                // if stack 1 is longer, move half of the elements to stack 2
                int amountToMove = (s1.size() - s2.size()) / 2;
                int s1Size = s1.size();
                for (int i = 0; i < (s1Size - amountToMove); i++) {
                    temp.push(s1.pop());
                }
                while (!s2.isEmpty()) {
                    temp2.push(s2.pop());
                }
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                while (!temp.isEmpty()) {
                    s1.push(temp.pop());
                }
                while (!temp2.isEmpty()) {
                    s2.push(temp2.pop());
                }
                s2.push(a);
            } 
        }
    }

    // Print out the entire deque
    public void printStacks() {
        // First print each elements of stack 1
        for (int i = s1.size() - 1; i >= 0; i--) {
            System.out.print(s1.get(i) + " ");
        }
        System.out.print("] ");
        System.out.print("[ ");
        // Print each elements of stack 2
        for (int i = 0; i < s2.size(); i++) {
            System.out.print(s2.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] Args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        // First push 20 elements into stack 1, from 1 to 20
        for (int i = 10; i > 0; i--) {
            s1.push(i);
        }
        // Then push 10 elements into stack 2, from 21 to 30
        for (int i = 11; i < 31; i++) {
            s2.push(i);
        }
        // Initialize the deque
        InfiniteStackAttack deque = new InfiniteStackAttack(s1, s2);

        // Print the deque
        deque.printStacks();

        // Push 32 to the back of the deque, and print the deque
        deque.pushLast(31);
        deque.printStacks();

        // Push 0 to the front of the deque, and print the deque
        deque.pushFirst(0);
        deque.printStacks();
    }
}
