import java.util.*;

// Solution for leetcode 283: Move Zeroes
// submission: https://leetcode.com/problems/move-zeroes/submissions/1468990354
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0) {
            return;
        }
        // start slow and fast at 0
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            // move fast pointer to the next non-zero element
            if (nums[fast] != 0) {
                // Swap elements at slow and fast if needed
                if (slow != fast) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
                slow++;
            }
        }
        // At the end, all elements after `slow` are zeroes
    }

    public static void main(String[] args) {
        // test case
        MoveZeroes sol = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); // [1, 3, 12, 0, 0]
    }
}