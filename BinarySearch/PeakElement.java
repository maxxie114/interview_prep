import java.util.*;

// Solution for leetcode 162: Find Peak Element
// Leetcode solution: https://leetcode.com/problems/find-peak-element/submissions/1445514367
public class PeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // left < right is the key, because we need to find the peak, and the peak must be at the right side
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if the mid is smaller than the mid + 1, then the peak must be at the right side
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            // if the mid is larger than the mid + 1, then the peak must be at the left side
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // test case
        PeakElement test = new PeakElement();
        int[] nums = {1, 2, 3, 1};
        System.out.println(test.findPeakElement(nums));  // 2
    }
}
