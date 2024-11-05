package BinarySearch;

public class leetcode33 {
    while left < = right {
        if nums[mid] == target {
            return mid
        // mid at first half
        } else if nums[mid] >= nums[left] {
            if target >= nums[left] && target < nums[mid] {
                right = mid - 1
            } else {
                left = mid + 1
            }
        // mid at second half	
        } else  {
            if target <= nums[right] && target > num[mid] {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    return -1
}
