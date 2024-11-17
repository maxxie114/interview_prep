import java.util.*;

// Solution for leetcode 912, quick sort in-place
// Leetcode submission: https://leetcode.com/problems/sort-an-array/submissions/1455110604
public class SortingQuickSortInPlace {
    private Random random = new Random();
    public int[] sortArray(int[] nums) {
        // check if the input is valid
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSortRecursion(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSortRecursion(int[] nums, int left, int right) {
        // base case
        if (left >= right) { // Correct base case
            return;
        }
        
        // get the correct position of the pivot
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivotCorrectPosition = quickSortHelper(nums, left, right, pivotIndex);

        // sort the left half
        quickSortRecursion(nums, left, pivotCorrectPosition - 1);
        // sort the right half
        quickSortRecursion(nums, pivotCorrectPosition + 1, right);
    }

    public int quickSortHelper(int[] nums, int left, int right, int pivot) {
        int pivotValue = nums[pivot];
        swap(nums, pivot, right); // Move pivot to end
        int i = left - 1;
        
        // move the pivot to the end
        for (int j = left; j < right; j++) {
            if (nums[j] < pivotValue) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right); // Move the pivot to the correct position
        return i + 1; // Return the correct position of the pivot
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] Args) {
        // test case
        SortingQuickSortInPlace s = new SortingQuickSortInPlace();
        int[] nums = new int[1000];
        java.util.Arrays.fill(nums, 2);
        int[] result = s.sortArray(nums);
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 2) {
                System.out.println("Error at index " + i);
            }
            System.out.println(result[i]);
        }
    }
}
