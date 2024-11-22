// Solution for leetcode 5: Longest Palindromic Substring
// leetcode submission: https://leetcode.com/problems/longest-palindromic-substring/submissions/1460143460
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int inputlength = s.length();

        // Create a 2D array to store the results of the palindromic substrings
        boolean[][] dp = new boolean[inputlength][inputlength];
        int resultStart = 0;
        int resultEnd = 0;
        int max = 0;

        for (int right = 0; right < inputlength; right++) {
            for (int left = 0; left <= right; left++) {
                // if the characters at the left and right are the same and the substring between them is a palindrome, then the substring is a palindrome
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left+1][right-1])) {
                    dp[left][right] = true;
                    if (right - left + 1 > max) {
                        max = right - left + 1;
                        resultStart = left;
                        resultEnd = right;
                    }
                }
            }
        }
        return s.substring(resultStart, resultEnd + 1);
    }

    public static void main(String[] args) {
        // Test cases
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("babad"));
    }
}
