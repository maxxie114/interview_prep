import java.util.*;

// implementation for leetcode 128 solution 2
public class LongestConsecutiveSequence2 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> hashSet = new Hashset<>();
        int result = 1;
    
        for (int num: nums) {
            hashSet.add(num);
        }
    
        // use num as the start/min number of the con seq
        for (int num: nums) {
            int curLength =1;
            int nextNum = num + 1;
            if (!hashSet.contains(num + 1)) {
                while (hashSet.contains(nextNum + 1)) {
                    curLength++;
                    nextNum++;
                    result = Math.max(result, curLength);
                }
            }
        }
        return result;
    }
}
