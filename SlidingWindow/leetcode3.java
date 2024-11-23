import java.util.HashSet;
import java.util.Set;

public class leetcode3 {
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

}
