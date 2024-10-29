import java.util.*;

// Solution for a modification of leetcode 23: Merge k Sorted ArrayLists
public class KSortedArrayList {
    // Input: ArrayList[] lists: A list of array lists
    // Output: Merged ArrayList
    public ArrayList<Integer> mergeKArrayLists(ArrayList<Integer>[] lists) {
        // Edge case
        if (lists == null || lists.length == 0) {
            return new ArrayList<>();
        }

        // Use a priority queue to store the first item of each of the arraylist
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new MyComparator());

        // Add the first item of each arraylist to the priority queue
        for (ArrayList<Integer> list : lists) {
            if (list != null && !list.isEmpty()) {
                pq.add(list);
            }
        }

        // Create a result list to store the merged result
        ArrayList<Integer> result = new ArrayList<>();

        // While there are items in the priority queue
        while (!pq.isEmpty()) {
            // Get the smallest arraylist from the priority queue
            ArrayList<Integer> smallestList = pq.poll();
            // Add the smallest item to the result
            result.add(smallestList.remove(0)); // Remove the first item from the smallest list

            // If there are still items in the smallest list, add it back to the priority queue
            if (!smallestList.isEmpty()) {
                pq.add(smallestList);
            }
        }

        return result; // Return the merged result
    }

    public static void main(String[] args) {
        // Test case
        KSortedArrayList solution = new KSortedArrayList();
        ArrayList<Integer>[] lists = new ArrayList[3];
        lists[0] = new ArrayList<>(Arrays.asList(1, 4, 5));
        lists[1] = new ArrayList<>(Arrays.asList(1, 3, 4));
        lists[2] = new ArrayList<>(Arrays.asList(2, 6));
        ArrayList<Integer> result = solution.mergeKArrayLists(lists);
        System.out.println(result); // Output: [1, 1, 2, 3, 4, 4, 5, 6]
    }
}

class MyComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> first, ArrayList<Integer> second) {
        // Compare the first elements of the two array lists
        if (first.get(0) == second.get(0)) {
            return 0;
        }
        return first.get(0) < second.get(0) ? -1 : 1;
    }
}
