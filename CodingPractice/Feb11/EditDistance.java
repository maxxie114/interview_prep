// Solution for leetcode 72: Edit Distance
// Submission: https://leetcode.com/problems/edit-distance/submissions/1539823696
public class EditDistance {
    public int minDistance(String word1, String word2) {
        // get the length of the two strings
        int m = word1.length();
        int n = word2.length();

        // Create a DP
        int[][] dp = new int[m+1][n+1];

        // populate the dp with zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }

        // base case 1: When word1 is empty, convert to word2 by inserting all characters.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // base case 2: When word2 is empty, convert from word1 by deleting all characters.
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Populate the rest of the dp table starting from index 1
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // first check the cost of the current cell
                // Every operation, insert, delete, or sub, is a cost of 1
                int cost = 0;
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    cost = 1;
                }

                // After that we calculate the minimum between
                // DP[i][j-1] + 1 (insertion)
                // DP[i - 1][j] + 1 (deletion)
                // and DP[i-1][j-1] + cost (substitution)
                int insert = dp[i][j - 1] + 1;
                int delete = dp[i - 1][j] + 1;
                int substitution = dp[i - 1][j - 1] + cost;
                dp[i][j] = Math.min(Math.min(insert, delete), substitution);
            }
        }

        return dp[m][n];
    }
}
