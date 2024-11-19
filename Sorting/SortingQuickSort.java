import java.util.*;
// Solution for leetcode 912: quick sort
// leetcode submission: https://leetcode.com/problems/sort-an-array/submissions/1457116916
public class SortingQuickSort {
    private final Random random = new Random(); // Create an instance of Random

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // Select a random pivot index between left and right (inclusive)
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(nums, pivotIndex, right); // Move pivot to the end

        // Perform partitioning
        int pivotFinalIndex = partition(nums, left, right);
        quickSort(nums, left, pivotFinalIndex - 1);  // Sort left part
        quickSort(nums, pivotFinalIndex + 1, right); // Sort right part
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right]; // Pivot is the element at the end
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i++, j);
            }
        }

        // Restore pivot to its correct position
        swap(nums, i, right);
        return i; // Return the position of the pivot after partitioning
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortingQuickSort solution = new SortingQuickSort();
        int[] nums = new int[100000];
        
        // Fill the array with the same value for testing purposes
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 2;
        }
        
        solution.sortArray(nums);

        // Verify sorted array (should be the same as input in this case)
        boolean sortedCorrectly = true;
        for (int num : nums) {
            if (num != 2) {
                sortedCorrectly = false;
                break;
            }
        }
        
        System.out.println("Array sorted correctly: " + sortedCorrectly);
    }
}
