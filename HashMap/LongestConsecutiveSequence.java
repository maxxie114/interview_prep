import java.util.*;

// Solution for leetcode 128
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // Create a hashset to store all the values
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Assume each number is the start of a sequence
        int longest = 0;
        for (int num : nums) {
            // if the number is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                // check for the next number in the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                longest = Math.max(longest, currentLength);
            }
        }
        return longest;
    }
}
