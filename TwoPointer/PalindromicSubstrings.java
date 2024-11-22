// Solution for leetcode 647: Palindromic Substrings
// Leetcode submission: https://leetcode.com/problems/palindromic-substrings/submissions/1460163839
public class PalindromicSubstrings {
    // This questions is pretty much exactly the same as leetcode 5: Longest Palindromic Substring
    // I can literlly copy and paste the solution from that question with a few modifications and it will work
    public int countSubstrings(String s) {
        int inputlength = s.length();

        boolean[][] dp = new boolean[inputlength][inputlength];
        int count = 0;

        // These two for loops are the same as the ones in leetcode 5
        for (int right = 0; right < inputlength; right++) {
            for (int left = 0; left <= right; left++) {
                // Different from leetcode 5, we don't need to keep track of the longest palindromic substring
                // We just need to keep track of the count of palindromic substrings
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left+1][right-1])) {
                    dp[left][right] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] Args) {
        // Test cases
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings("aaa")); // Expected output: 6
    }
}
