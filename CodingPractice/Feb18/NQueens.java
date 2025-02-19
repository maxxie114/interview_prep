// Leetcode 51: N-Queens
// Submission: https://leetcode.com/problems/n-queens/submissions/1548116935

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        // First create a result array that holds all valid board configuration
        List<List<String>> result = new ArrayList<>();

        // Array to record the queen position of each row, each index in the array represent one row
        int[] queenPosition = new int[n];

        // Create three new sets to track for columns and diagonals that are already occupied
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        // Start the dfs backtracking starting at row 0
        int row = 0;
        backtrack(n, row, queenPosition, columns, diag1, diag2, result);

        // once the backtracking is done, return the result
        return result;
    }

    // backtracking dfs function with the n, current row, queenPositions, columns set, diag1, diag2, and result as input
    private void backtrack(int n, int row, int[] queenPositions, Set<Integer> columns, Set<Integer> diag1, Set<Integer> diag2, List<List<String>> result) {
        // base case: if row equals to n, that means we have already finished one traversal, and one solution have been found
        // So we just record the current queenPosition and call the broad contruction method to build the broad array
        if (row == n) {
            List<String> broad = broadConstructor(queenPositions, n);
            result.add(broad);
            return;
        }

        // recursion case: if a solution have not yet been found, then try placing a queen on each column of the current row
        for (int col = 0; col < n; col++) {
            // if the current column or either diagonal is already occupied, then we don't want to place a queen there
            // The math behind row + col, and row - col is this:
            // since all slope in a chess broad is either 1 or -1, then we have y = -x + b -> y + x = b, and b is a constant, which means all points with the same b would be on the same diagonals, same idea applies to positive slope
            if (columns.contains(col) || diag1.contains(row + col) || diag2.contains(row - col)) {
                continue;
            }

            // if the current column is not occupied, place the queen there and then mark it as occupied
            queenPositions[row] = col;

            // mark as occupied
            columns.add(col);
            diag1.add(row+col);
            diag2.add(row-col);

            // After placing the queen, call the dfs for the next row
            backtrack(n, row+1, queenPositions, columns, diag1, diag2, result);

            // After that, we need to reset the status of the current placement by marking the column as unoccupied
            columns.remove(col);
            diag1.remove(row+col);
            diag2.remove(row-col);
        }
    }
    
    // the broad constructor take the queen position and n as input, an return an array of string that shows the broad
    private List<String> broadConstructor(int[] queenPositions, int n) {
        List<String> broad = new ArrayList<>();
        // loop through each row and column of the broad, and use string builder to add a . or a Q onto that cell
        for (int row = 0; row < n; row++) {
            // For each row, build a string
            StringBuilder temp = new StringBuilder();
            for (int col = 0; col < n; col++) {
                // put a . or a Q based on the value in queenPositions
                if (queenPositions[row] == col) {
                    temp.append("Q");
                } else {
                    temp.append(".");
                }
            }
            broad.add(temp.toString());
        }
        return broad;
    }
}