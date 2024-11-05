package BinarySearch;

public class leetcode162 {
    public int findPeakElement(int[] nums) {
        left = 0
        right = num.length - 1
        while left < right {
            mid = left + (right - left) / 2
            // mid is not peak, and peak must be at the right side
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1
            // mid must be at the left, and it might include mid itself 
            } else {
                right = mid
            }
        }
        return left
    }
}
