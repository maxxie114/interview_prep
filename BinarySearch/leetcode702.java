class Solution {
    int binarySearch() {
        if num == null {
            return -1
        }
        
        left = 0
        right = 0
        
        while left <= right {
            // This way it won't go overbound
            mid = left + (right - left) / 2
        
            if num[mid] == target {
                return mid
            }  else if num[mid] > target {
                right = mid - 1 // mid is useless, remove
            } else {
                left =  mid + 1
            }
        
            return -1
        }
    }
}