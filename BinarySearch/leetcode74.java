package BinarySearch;

public class leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        totalRow = matrix.length
        totalCol = matrix[0].length
        left = 0
        right = totalRow * totalCol - 1

        while left <= right {
            mid = left + right - left / 2
            midRow = mid / totalCol
            midCol = mid % totalCol
            if matrix[midRow][midCol] == target {
                return true	
            }	matrix[midRow][midCol] > target {
                right = mid - 1
            }	else {
                left = mid + 1
            }
        }
        return false
    }
}
