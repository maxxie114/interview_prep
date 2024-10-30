import java.util.*;

// Array Sort: Given an array that is initially stored in one stack, sort it with another stack
public class StackSorting {
    public ArrayDeque<Integer> sort(ArrayDeque<Integer> input) {
        // Create a temp stack
        ArrayDeque<Integer> tempStack = new ArrayDeque<>();
        int alreadySortedItems = 0; // track the items that are already sorted

        // Continue until the input stack is sorted
        while (input.size() > alreadySortedItems) {
            
            int max = Integer.MIN_VALUE; // Initialize max to the smallest integer
            int maxCount = 0; // Count how many times the max value appears

            // Transfer all items to the temp stack, finding the max value
            while (input.size() > alreadySortedItems) {
                int current = input.pop();
                tempStack.push(current);

                // Update max and maxCount
                if (current > max) {
                    max = current; // if current is greater than max, update max, and reset maxCount
                    maxCount = 1;
                } else if (current == max) {
                    maxCount++; // if current is equal to max, increment maxCount
                }
            }

            // Transfer all occurrances of the max value back to the input stack
            for (int i = 0; i < maxCount; i++) {
                input.push(max);
            }
            
            // Update alreadySortedItems
            alreadySortedItems += maxCount;

            // Transfer the remaining items back to the input stack, ignore the max values
            while (!tempStack.isEmpty()) {
                int current = tempStack.pop();
                if (current != max) {
                    input.push(current);
                }
            }
        }
        return input; // Return the sorted stack
    }
    
    public static void main(String[] args) {
        // test case [5,6,7,7,2,3,4,1]
        StackSorting sorter = new StackSorting();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // Push each item onto the stack
        int[] temp = {5, 6, 7, 7, 2, 3, 4, 1};
        for (int i : temp) {
            stack.push(i);
        }
        ArrayDeque<Integer> sortedStack = sorter.sort(stack);
        // pop each item and print it
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        } // Output should be 1, 2, 3, 4, 5, 6, 7, 7
    }
}
