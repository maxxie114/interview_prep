import java.util.HashSet;
import java.util.Set;

// Solution for leetcode 3: Longest Substring Without Repeating Characters
// Submission: https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1468972813
public class LongesetSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            Character curChar = s.charAt(right);
            if (!set.contains(curChar)) {
                set.add(curChar);
                max = Math.max(max, set.size());
            } else {
                // We don’t need to consider the first if case, since it won’t enter the loop
                while (s.charAt(left) != curChar) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        // Test cases
        LongesetSubstring l = new LongesetSubstring();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(l.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(l.lengthOfLongestSubstring("pwwkew")); // 3
    }
}
