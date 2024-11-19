import java.util.*;
// Solution for leetcode 912: quick sort
// leetcode submission: https://leetcode.com/problems/sort-an-array/submissions/1457134703
public class SortingQuickSort {
    private final Random random = new Random(); // Create an instance of Random
    
    public int[] sortArray(int[] nums) {
        // corner case
        if (nums == null || nums.length < 2) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        // use random to select the pivot
        int pivotIndex = random.nextInt(right - left + 1) + left;
        swap(nums, pivotIndex, right); // move pivot to the end
        pivotIndex = partition(nums, left, right);

        quickSort(nums, left, pivotIndex - 1); // sort left part
        quickSort(nums, pivotIndex + 1, right); // sort right part
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right]; // pivot is already at the end

        // Loop invariant: [left, i) <= pivot, [i, j) > pivot
        int i = left;
        for (int j = left; j < right; j++) {
            // It should be nums[j] < pivot, not nums[j] <= pivot
            // because we want to make sure that nums[i] < pivot
            if (nums[j] < pivot) {
                swap(nums, i++, j);
            }
        }

        // swap pivot back to the correct position
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] Args) {
        // test case
        SortingQuickSort solution = new SortingQuickSort();
        int[] nums = {5, 2, 3, 1};
        int[] result = solution.sortArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
