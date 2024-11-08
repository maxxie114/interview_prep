import java.util.*;

// Solution for leetcode 74: Search a 2D Matrix
// leetcode submission: https://leetcode.com/problems/search-a-2d-matrix/submissions/1446552816
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRow = matrix.length; // number of rows
        int totalCol = matrix[0].length; // number of columns
        int left = 0;
        int right = totalRow * totalCol - 1; // total number of elements

        // binary search
        while (left <= right) {
            int mid = left + right - left / 2;
            int midRow = mid / totalCol; // this calculates the row number
            int midCol = mid % totalCol; // this calculates the column number by using the remainder of the division
            // if the target is found
            if (matrix[midRow][midCol] == target) {
                return true;
            // if the target is less than the middle element
            } else if (matrix[midRow][midCol] > target) {
                right = mid - 1;
            // if the target is greater than the middle element
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // test case
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        SearchA2dMatrix sol = new SearchA2dMatrix();
        System.out.println(sol.searchMatrix(matrix, target)); // true
    }
}
