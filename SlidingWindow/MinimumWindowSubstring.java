import java.util.*;

// Solution for leetcode 76: Minimum Window Substring
// Submission: https://leetcode.com/problems/minimum-window-substring/submissions/1469079304
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<Character, Integer>();
        for (Character c : t.toCharArray()) {
            // put the character in the map
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int matches = 0;
        int slows = 0;
        int resultStart = 0;
        int resultLength = Integer.MAX_VALUE;

        // Loop fast pointer from 0 to s.length
        for (int fast = 0; fast < s.length(); fast++) {
            Character curChar = s.charAt(fast);
            // We use integer here because the value can be null
            Integer curCount = tmap.get(curChar);

            // If the current character is in the map
            if (curCount != null) {
                curCount--;
                if (curCount == 0) {
                    matches++;
                }
                // update the count of the curChar in the map
                tmap.put(curChar, curCount);
            }

            while (matches == tmap.size()) {
                int curLength = fast - slows + 1;
                if (curLength < resultLength) {
                    resultLength = curLength;
                    resultStart = slows;
                }
                curChar = s.charAt(slows);
                curCount = tmap.get(curChar);
                if (curCount != null) {
                    curCount++;
                    if (curCount > 0) {
                        matches--;
                    }
                    // update the count of the curChar in the map
                    tmap.put(curChar, curCount);
                }
                slows++;
            }
        }
        // If the resultLength is still Integer.MAX_VALUE, return ""
        if (resultLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    public static void main(String[] args) {
        // test case
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow("ADOBECODEBANC", "ABC")); // BANC
    }
}
