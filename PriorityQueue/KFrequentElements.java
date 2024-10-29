import java.util.*;

// Solution for leetcode 347: Top K Frequent Elements
public class KFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Edge case
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        // Use a hashmap to store the count for each number
        Map<Integer, Integer> countMap = new HashMap<>();
        // The PQ store a map entry
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new MyComparator());

        // Count the frequency of each number and put into the hashmap
        for (int num : nums) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 0);
            }
            countMap.put(num, countMap.get(num) + 1);
        }

        // Add all entries from the countMap to the priority queue
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            pq.add(entry);
        }

        // Prepare the result array and retrieve the k most frequent elements from the priority queue
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        // test case 
        KFrequentElements solution = new KFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] topKFrequent = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(topKFrequent)); // [1, 2] or [2, 1]
    }
}

class MyComparator implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> first, Map.Entry<Integer, Integer> second) {
        // Compare the frequencies
        return first.getValue() > second.getValue() ? -1 : 1;
    }
}
