// Solution for leetcode 694: Number of distinct islands

import java.util.*;

public class NumberOfDistinctIslands {
    // First we need a visited array, and a stringbuilder for a island code
    private boolean[][] visited;
    public int numDistinctIslands(int[][] grid) {
        this.visited = new boolean[grid.length][grid[0].length]; // create a boolean array that is the size of the grid
        Set<String> islands = new HashSet<>(); // create a hashset to store all existing islands type

        // start a dfs from each grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                StringBuilder island = new StringBuilder(); // create a stringbuilder to build the island
                dfs(row, col, island, grid, 'X');

                // If the island is an actual island (meaning it has at least one block of land), add it to the list of islands
                if (island.length() != 0) {
                    String island_code = island.toString();
                    islands.add(island_code);
                }
                
            }
        }

        return islands.size(); // return the types of islands on the grid
    }

    public void dfs(int row, int col, StringBuilder island, int[][] grid, char dir) {
        // base case: if the node is outside of the grid, return
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }

        // edge case: if the node is visited, or if the current node on the grid is a 0 (ocean), return
        if (visited[row][col] || grid[row][col] == 0) {
            return;
        }

        // recursive case: if the node is not visited, mark it, and append the current direction into the string builder
        // traverse all four directions, after traversing, we need to backtrack the status, to mark a backtrack we use a 'X'
        // For direction we use U D L R
        visited[row][col] = true;
        island.append(dir);
        dfs(row - 1, col, island, grid, 'U');
        dfs(row + 1, col, island, grid, 'D');
        dfs(row, col + 1, island, grid, 'R');
        dfs(row, col - 1, island, grid, 'L');
        island.append('X'); // backtrack the status
    }
}
