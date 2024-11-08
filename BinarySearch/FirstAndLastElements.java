import java.util.*;

// solution for leetcode 34: Find First and Last Position of Element in Sorted Array
// leetcode submission: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1446604155
public class FirstAndLastElements {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        // corner case
        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = 0;
        int right = nums.length - 1;

        // left < right is the key
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // we use >= here instead of >, because we want to find the first occurance
            if (nums[mid] >= target) {
                // if first occurance is right on target
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] != target) {
            return result; // Target not found
        }
        result[0] = left;

        // last occurance
        // reset right for the next binary search
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1; // make mid biased to the right
        
            if (nums[mid] <= target) {
                // if first occurance is right on target
                // mid is still useful
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        result[1] = right;
        return result;
    }
    
    public static void main(String[] args) {
        // test case
        FirstAndLastElements solution = new FirstAndLastElements();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]); // 3 4
    }
}