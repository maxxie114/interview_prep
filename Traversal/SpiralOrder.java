import java.util.*;

// Leetcode 54 Spiral Order
class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Initialize the result list
        List<Integer> result = new ArrayList<>();
        // Check if the matrix is empty
        if(matrix.length == 0) {
            return result;
        }
        // Initialize the variables
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        // Traverse the matrix
        while (top <= bottom && left <= right) {
            // Edge cases: If there is only one row
            if (matrix.length == 1) {
                break;
            } 

            for (int i = 0; i < right + 1; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;


            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            

            for (int i = bottom; i >= top+1; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        // Check if the matrix has odd number of rows
        if (top == bottom) {
            // Deal with edge cases and missing one row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
        } 
        return result;
    }

    // Write a test script
    public static void main(String[] Args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        // Edge cases
        int[][] matrix00 = {};
        int[][] matrix03 = {{1, 2, 3}};
        int[][] matrix30 = {{1}, {2}, {3}};

        // Test cases
        int[][] matrix33 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix34 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix44 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        // Test for all the cases
        List<Integer> result = spiralOrder.spiralOrder(matrix33);
        System.out.println(result);

        result = spiralOrder.spiralOrder(matrix34);
        System.out.println(result);

        result = spiralOrder.spiralOrder(matrix44);
        System.out.println(result);

        result = spiralOrder.spiralOrder(matrix00);
        System.out.println(result);

        result = spiralOrder.spiralOrder(matrix03);
        System.out.println(result);

        result = spiralOrder.spiralOrder(matrix30);
        System.out.println(result);
    }
}