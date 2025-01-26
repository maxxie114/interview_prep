import java.util.LinkedList;
import java.util.Queue;

// Solution for leetcode 542: 01 Matrix
// Solution: https://leetcode.com/problems/01-matrix/submissions/1520142478
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        // initialize all the values
        int[][] result = new int[mat.length][mat[0].length];
        int rows = mat.length; // These two always need to be initialized first, because it can be updated in the bfs
        int cols = mat[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // iterate through the matrix
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // if the current element is 0, we add it to the queue 
                if (mat[row][col] == 0) {
                    result[row][col] = 0; // set the value to 0
                    q.add(new int[]{row, col}); // add the row and col to the queue
                    visited[row][col] = true; // mark as visited
                } else {
                    result[row][col] = Integer.MAX_VALUE; // set the value to max value, unvisited
                }
            }
        }

        // run the bfs logic to update the result
        // This is more efficient than the previous one because we don't need to check if the value is 1
        bfs(result, q, visited);

        return result;
    }

    private void bfs(int[][] result, Queue<int[]> q, boolean[][] visited) {
        // bfs logics
        // First we need to define the directions
        int[][] DIR = {{1,0},{0,1},{-1,0},{0,-1}};

        // run the bfs logic
        while (!q.isEmpty()) {
            // get the current row and cols
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            // iterate through the directions
            for (int[] dir : DIR) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];

                // check if the new row and new col are within the boundary
                // row is more than 0, less than the length of the result; col is more than 0, less than the length of the result[0] and if it is not visited
                if (newRow >= 0 && newRow < result.length && newCol >= 0 && newCol < result[0].length && !visited[newRow][newCol]) {
                    result[newRow][newCol] = result[curRow][curCol] + 1; // update the result
                    q.add(new int[]{newRow, newCol}); // add the new row and new col to the queue
                    visited[newRow][newCol] = true; // mark as visited
                }
            }
        }
    }
}