public class SortingMergeSort {
    public int[] sortArray(int[] nums) {
        // check if the input is valid
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] temp = new int[array.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    public void mergeSort(int[] nums, left, right) {
        // base case
        if (left > right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);
        merge(nums, left, middle, right, temp);
    } 

    public void merge(int[] nums, int left, int mid, int right, int[] temp) {
        // Copy everything from left to right to the temp array
        for (int i = left; i < right; i++) {
            temp[i] = nums[i];
        }

        int i = left; // i points to left, first half is from i to mid
        int j = mid + 1; // j point to mid + 1, second half is from j to right
        int k = left; // index of the merged array start at left

        // as long as there are stll elements that needs to be merged
        // stop the loop when i passes mid, and j passes right
        while (i <= mid && j <= right) {
            // if the index at the left half is smaller
            if (temp[i] < temp[j]) {
                nums[k] = temp[i];  
                k++;
                i++;
            // the value of the index at the right half is bigger
            } else {
                nums[k] = temp[j];
                k++;
                j++;
            }
        }

        // Copy all the remaining items to nums from the left array, just incase if there is a situation where 
        // if there are anything from the left array that are not copied over
        while (i <= mid) {
            nums[k] = temp[i];
        }

        // Any items from the right array no longer need to be copied, since they would already be in place
    }

    // Test the algorithm
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        sorter.mergeSort(array);
        
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}