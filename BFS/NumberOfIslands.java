import java.util.LinkedList;
import java.util.Queue;
// Solution for leetcode 200: Number of Islands
// Submissions: https://leetcode.com/problems/number-of-islands/submissions/1475366637
public class NumberOfIslands {
    // Directions representing right, left, down, up movements
    private static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0; // edge case: empty grid
        }

        int numIslands = 0; // Initial count of islands
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // If we find a piece of land, perform BFS to mark the entire island
                if (grid[row][col] == '1') {
                    numIslands++;
                    bfs(grid, row, col, q);
                }
            }
        }

        return numIslands;
    }

    private void bfs(char[][] grid, int startRow, int startCol, Queue<int[]> q) {
        q.add(new int[]{startRow, startCol});
        grid[startRow][startCol] = '0'; // Mark the starting cell as visited

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : DIR) {
                int newRow = cur[0] + dir[0];
                int newCol = cur[1] + dir[1];
                // Check if the new position is within bounds and is unvisited land
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0'; // Mark as visited
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}
