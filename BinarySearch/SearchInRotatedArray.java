import java.util.*;

// Solution for leetcode 33: Search in Rotated Sorted Array
// leetcode submission: https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1448433462
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        // edge case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // define left right
        int left = 0;
        int right = nums.length - 1;
        // left <= right is the key
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // find the target
            if (nums[mid] == target) {
                return mid;
            // mid at first half
            } else if (nums[mid] >= nums[left]) {
                // if target bigger or equals to left and smaller than mid, that means target is in the first half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                // otherwise, target is in the second half
                } else {
                    left = mid + 1;
                }
            // mid at second half	
            } else  {
                // if target smaller or equals to right and bigger than mid, that means target is in the second half
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                // otherwise, target is in the first half
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] Args) {
        // test case
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        SearchInRotatedArray test = new SearchInRotatedArray();
        System.out.println(test.search(nums, target)); // 4
    }
}
