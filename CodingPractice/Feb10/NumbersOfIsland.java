// Solution for leetcode 200: Numbers of Islands
// Submission: https://leetcode.com/problems/number-of-islands/submissions/1538969051
// This is a dfs approach
public class NumbersOfIsland {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        this.visited = new boolean[grid.length][grid[0].length];
        Integer result = 0;


        // start a dfs from every single node
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (visited[row][col] == false && grid[row][col] == '1') {
                    result++;
                    dfs(row, col, grid, visited);
                }
            }
        }
        return result;
    }


    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        // edge case: if it is outside of the grid, return
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }


        // base case: if it reach 0, return
        if (visited[row][col] == true || grid[row][col] == '0') {
            return;
        }


        // mark visited
        visited[row][col] = true;
        dfs(row - 1, col, grid, visited); // up
        dfs(row + 1, col, grid, visited); // down
        dfs(row, col - 1, grid, visited); // left
        dfs(row, col + 1, grid, visited); // right
    }
}
