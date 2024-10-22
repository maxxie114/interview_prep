// Solution for leetcode 350
import java.util.*;

public class IntersectionTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Map to store number counts from nums1
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Filling the map with frequency of numbers in nums1
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // List to store the intersection
        List<Integer> intersection = new ArrayList<>();
        
        // Checking nums2 for common elements
        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                intersection.add(num);
                countMap.put(num, countMap.get(num) - 1); // Decrease the count in the map
            }
        }
        
        // Convert the list to an array
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        IntersectionTwoArrays solution = new IntersectionTwoArrays();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [4, 9]
    }
}