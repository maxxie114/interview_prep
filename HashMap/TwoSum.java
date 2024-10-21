import java.lang.reflect.Array;
import java.util.*;

// Solution for leetcode 1
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        // put the value and index of num into the hashmap
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // for each item, check for the complement in the hashmap
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // if the complement is in the hashmap and the index is not the same as the current index
            if (map.containsKey(complement) && map.get(complement) != i) {
                result[0] = i;
                result[1] = map.get(complement);
            }
        }
        return result;
    }

    public static void main(String[] Args) {
        // test case
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum test = new TwoSum();
        int[] result = test.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // [0, 1]
    }
}
