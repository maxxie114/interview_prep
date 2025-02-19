// leetcode 200: Numbers of Islands
// Submission: https://leetcode.com/problems/number-of-islands/submissions/1547990890
public class NumbersOfIslands {
    public int numIslands(char[][] grid) {
        // Initialize a visited grid and a count variable
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        // loop through every single cell of the grid, and start a dfs from that cell if it is not visited and not 0
        // also if any cells are not 1, then we can see it as a new island and increment the count
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (visited[row][col] == false && grid[row][col] == '1') {
                    count++;
                    // dfs should have the row, col, grid, and the visited array as the input
                    dfs(row, col, grid, visited);
                }
            }
        }
        // when the entire traversal is done, we just return the count
        return count;
    }

    // the dfs has row, col, grid, and visited grid as the input
    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        // base case: if the row and col are not within the bound, then we don't need to traverse anymore, so we return
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        // base case: if the cell is a 0, or if it is already visited, return
        if (grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        // recursion case: for anything that is not visited, we first mark it as visited, and then we traverse all four of the cells around it (up, down, left, right)
        visited[row][col] = true;
        // traverse all four directions
        dfs(row - 1, col, grid, visited); // up
        dfs(row + 1, col, grid, visited); // down
        dfs(row, col - 1, grid, visited); // left
        dfs(row, col + 1, grid, visited); // right
    }
}