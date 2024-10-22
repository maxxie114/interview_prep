import java.util.*;

// Solution for Leetcode 380
public class InsertDeleteGetRandom {
    // Store numbers and their indices
    private Map<Integer, Integer> numToIndex;
    private List<Integer> nums;
    private Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        numToIndex = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) {
            return false; // The element already exists
        }
        // Add the element to the nums list and save its index in the map
        numToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) {
            return false; // The element does not exist
        }
        // Get the index of the element to remove
        int index = numToIndex.get(val);
        // Swap the element with the last one
        int lastElement = nums.get(nums.size() - 1);
        nums.set(index, lastElement);
        numToIndex.put(lastElement, index);
        // Remove the last element
        nums.remove(nums.size() - 1);
        numToIndex.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom randomizedSet = new InsertDeleteGetRandom();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // 1 or 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // 2
    }
}
