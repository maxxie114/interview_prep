public class leetcode647 {
    countSubstrings(s) {
        inputlength = s.length

        dp = new boolean[inputlength][inputlength]
        count = 0

        for right from 0 to inputlength {
            for left from 0 to right + 1 {
                if s[right] == s[left] and right - left <= 2 or dp[left+1][right-1] {
                    dp[left][right] = true
                    count++
                }
            }
        }
        return count
    }
}
