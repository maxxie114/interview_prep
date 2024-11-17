import java.util.*;

// Solution for leetcode 912, using merge sort in place
// leetcode submission: https://leetcode.com/problems/sort-an-array/submissions/1455089636
class SortingMergeSortInPlace {
	// create a helper array in the class
	private int[] helper;

    public int[] sortArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		helper = new int[nums.length];
		mergeSort(nums, helper, 0, nums.length - 1);
		return nums;
    }

	public void mergeSort(int[] nums, int[] helper, int left, int right) {
		if (left == right) {
			return;
		}
		
		int mid = left  + (right - left) / 2;
		// sort the left half
		mergeSort(nums, helper, left, mid);
		// sort the right half
		mergeSort(nums, helper, mid+1, right);
		// merge the two halves
		merge(nums, helper, left, mid, right);
	}

	public void merge(int[] nums, int[] helper, int left, int mid, int right){
		// dump everything into the helper
		for (int i = left; i <= right; i++) {
			helper[i] = nums[i];
		}

		int helperLeft = left;
		int helperRight = mid + 1;
		while (helperLeft <= mid && helperRight <= right) {
			if (helper[helperLeft] <= helper[helperRight]) {
				// helper does not change, it acts as a reference
				nums[left] = helper[helperLeft];
				left++;
				helperLeft++;
			}
			else {
				nums[left] = helper[helperRight];
				left++;
				helperRight++;
			}
		}

		while (helperLeft <= mid) {
			nums[left] = helper[helperLeft];
			left++;
			helperLeft++;
		}
	}
	
	public static void main(String[] args) {
		// test case
		SortingMergeSortInPlace s = new SortingMergeSortInPlace();
		int[] nums = {5, 2, 9, 1, 5, 6, 7, 8, 3, 4};
		int[] result = s.sortArray(nums);
		System.out.println(Arrays.toString(result));
	}
}