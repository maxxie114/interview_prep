import java.util.*;

// Solution for Leetcode 73
public class SetMatrixZero {
    
    public void setZeroes(int[][] matrix) {
        // Create two hashset, one for rows one for columns
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // Iterate through the matrix and add the row and column to the hashset, if the value is 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate through the matrix and set the row and column to 0 if the row or column is in the hashset
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // If the row or column is in the hashset, set the value to 0
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Main method for testing
        SetMatrixZero smz = new SetMatrixZero();
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        smz.setZeroes(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row)); // [1, 0, 1] [0, 0, 0] [1, 0, 1]
        }
    }
}