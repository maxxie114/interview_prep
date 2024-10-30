import java.util.*;

/* Kth Smallest Number: Given an integer k, find the kth smallest number s such that
s = 3 ^ x * 5 ^ y * 7 ^ z, provided that x > 0, y > 0, z > 0, and x, y, z are integers. 

Solution: We can look at this question like this, we can see this as a BFS, where we are searching down 
three different paths, we start with the smallest number, where x, y, z are all 1, and we can calculate the next
three numbers by incrementing x, y, or z by 1, then we can go down the tree and look for all the possible numbers,
and we can use a priority queue to keep track of the smallest numbers we have seen so far. 
*/
public class KSmallestNumber {
    public int kthSmallest(int k) {
        // Create a priority queue to store the numbers
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
        // Create a hashset to avoid duplicates
        HashSet<Integer> set = new HashSet<>();

        // Start with the smallest number and push to pq
        int start = 3 * 5 * 7; // 3^1 * 5^1 * 7^1
        pq.add(start);

        // Keep track of the current number, so we can find the next 3 numbers
        int currentNumber = 0;

        // Loop until we find the kth smallest number
        for (int i = 0; i < k; i++) {
            // Get the smallest number from the priority queue
            // System.out.println("Current number: " + currentNumber);
            currentNumber = pq.poll();

            // Generate the next three numbers
            int next1 = currentNumber * 3; // increment x
            int next2 = currentNumber * 5; // increment y
            int next3 = currentNumber * 7; // increment z
            // System.out.println("Next numbers: " + next1 + ", " + next2 + ", " + next3);

            // Add the next numbers to the priority queue if they are not already present
            if (!set.contains(next1)) {
                pq.add(next1);
                set.add(next1);
            }
            if (!set.contains(next2)) {
                pq.add(next2);
                set.add(next2);
            }
            if (!set.contains(next3)) {
                pq.add(next3);
                set.add(next3);
            }
        }
        return currentNumber; // Return the kth smallest number
    }

    public static void main(String[] args) {
        // test case
        KSmallestNumber kSmallestNumber = new KSmallestNumber();
        int k = 15; // Example input
        int result = kSmallestNumber.kthSmallest(k);
        System.out.println("The " + k + "th smallest number is: " + result); // 8505
    }   
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        // if the two numbers are equal
        if (a.equals(b)) {
            return 0;
        }
        // compare the two numbers
        return a < b ? -1 : 1;
    }
}
