// Second Practice of leetcode 200: Numbers of Island
// https://leetcode.com/problems/number-of-islands/submissions/1518682337
import java.util.LinkedList;
import java.util.Queue;

public class NumbersOfIsland2 {
    // final variable defining all four moving directions, representing up down left right
    private static final int[][] DIR = {{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // initialize all the values, number of islands, and the rows, and columns
        int numIsland = 0;
        int rows = grid.length;
        int cols = grid[0].length; // We can't directly put these into the for loop because it can be updated in the bfs
        // Declare a queue as an int array so that we can store the row and col
        Queue<int[]> q = new LinkedList<>(); 

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // It is a char array so we need to compare with '1' not 1
                if (grid[row][col] == '1') {
                    numIsland++;
                    bfs(grid, row, col, q);
                }
            }
        }
        return numIsland;
    }

    public void bfs(char[][] grid, int startRow, int startCol, Queue<int[]> q) {
        // add the startRow and startCol to the queue
        q.add(new int[]{startRow, startCol});
        // mark the startRow and startCol as visited, this need to be marked first or it will mess up the bfs
        grid[startRow][startCol] = '0';

        while (!q.isEmpty()) {
            // pull the current element from the queue and store it into an int array
            int[] cur = q.poll();
            for (int[] item : DIR) {
                int newRow = cur[0] + item[0];
                int newCol = cur[1] + item[1];
                // check if the new row and new col are within the boundary and if the value is 1
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 0; // mark as visited
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}
