import java.util.*;

// Solution for leetcode 240
public class Search2DMatrix {
    // This problem is a variant of binary search. We start from the top right corner of the matrix.
    // If the target is less than the current element, we move left. If the target is greater than the current element, we move down.
    // We continue this process until we find the target or go out of bounds.
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length -1;
        // Loop as long as we are within the matrix
        while (row < matrix.length && col >= 0) {
            // If we find the target, return true
            if (matrix[row][col] == target) {
                return true;
            } 
            // If the target is less than the current element, move left
            if (matrix[row][col] > target) {
                col--;
            }
            // If the target is greater than the current element, move down
            else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix solution = new Search2DMatrix();
        
        // Test Case 1
        int[][] matrix1 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target1 = 5;
        boolean result1 = solution.searchMatrix(matrix1, target1);
        System.out.println("Test Case 1: " + result1); // Expected: true
    
        // Test Case 2
        int target2 = 20;
        boolean result2 = solution.searchMatrix(matrix1, target2);
        System.out.println("Test Case 2: " + result2); // Expected: false
    
        // Test Case 3
        int[][] matrix2 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target3 = 3;
        boolean result3 = solution.searchMatrix(matrix2, target3);
        System.out.println("Test Case 3: " + result3); // Expected: true
    
        // Test Case 4
        int target4 = 13;
        boolean result4 = solution.searchMatrix(matrix2, target4);
        System.out.println("Test Case 4: " + result4); // Expected: false
    }
}
