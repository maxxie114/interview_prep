public class leetcode34 {
    left = 0
    right = nums.length - 1
    result = [-1,-1]

    // left == right - 1
    while left < right - 1 {
	    mid = left + (right - left) / 2
	
	    if nums[mid] == target {
		    // if first occurance is right on target
		    // mid is still useful
		    right = mid;
	    } else if nums[mid] > target {
		    right = mid - 1
	    } else {
		    left = mid + 1
	    }
    }

    if nums[left] == target {
        result[0] = nums[left]
    }	else if nums[right] == target {
        result[0] = nums[right]
    }

    // last occurance
    while left < right - 1 {
	    mid = left + (right - left) / 2
	
	    if nums[mid] == target {
            // if first occurance is right on target
            // mid is still useful
            right = mid;
	    } else if nums[mid] > target {
            right = mid - 1
	    } else {
            left = mid + 1
	    }
    }

    if nums[right] == target {
        result[1] = nums[right]
    }	else if nums[left] == target {
        result[1] = nums[left]
    }

    return result
}