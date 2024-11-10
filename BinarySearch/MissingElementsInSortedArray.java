import java.util.*;

// Solution for leetcode 1060: Missing Element in Sorted Array
// leetcode submission: https://leetcode.com/problems/missing-element-in-sorted-array/submissions/1448512563
public class MissingElementsInSortedArray {
    // Define a helper function that returns the total number of missing numbers
    // between the first element and the element at the index
    int totalMissingNumber(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }

    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        // loop until left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (totalMissingNumber(nums, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // if the k missing number is beyond the last element
        if (totalMissingNumber(nums, left) < k) {
            return nums[left] + k - totalMissingNumber(nums, left);
        }

        // Calculation theory: nums[left - 1] + k - missing count up to left-1
        return nums[left - 1] + k - totalMissingNumber(nums, left - 1);
    }

    public static void main(String[] args) {
        MissingElementsInSortedArray solution = new MissingElementsInSortedArray();
        int[] nums = {4, 7, 9, 10};
        int k = 1;
        System.out.println(solution.missingElement(nums, k)); // should be 5
        k = 3;
        System.out.println(solution.missingElement(nums, k)); // should be 8
        k = 4;
        System.out.println(solution.missingElement(nums, k)); // should be 11
    }
}
