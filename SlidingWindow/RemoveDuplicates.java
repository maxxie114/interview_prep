import java.util.*;

// solution for leetcode 26: Remove Duplicates from Sorted Array
// leetcode submission: https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1469087734
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // edge case
        if (nums.length == 0) return 0;

        // fast and slow start at 0
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            // fast move to the first num != slow
            while (fast < nums.length && nums[fast] == nums[slow]) {
                fast++;
            }
            // assign ++slow with fast
            if (fast < nums.length) {
                nums[++slow] = nums[fast];
            }
            // increment fast until slow != fast
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        // test case
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(rd.removeDuplicates(nums)); // 5
    }
}
