import java.util.*;

// Solution for 23: Merge k Sorted Lists
public class KSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Use a priority queue to store the head of each list
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new MyComparator());

        // Add the head of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // Create a temp node to help with the merging process
        ListNode temp = new ListNode(0);
        ListNode current = temp; // Pointer to the current node in the merged list

        // While there are nodes in the priority queue
        while (!pq.isEmpty()) {
            // Get the smallest node from the priority queue
            ListNode smallestNode = pq.poll();
            current.next = smallestNode; // Link the smallest node to the merged list
            current = current.next; // Move to the next position in the merged list

            // If there is a next node in the list, add it to the priority queue
            if (smallestNode.next != null) {
                pq.add(smallestNode.next);
            }
        }

        return temp.next; // Return the merged list, which starts from the next of the temp node
    }

    public static void main(String[] args) {
        // Test case
        KSortedList solution = new KSortedList();
        ListNode[] lists = {
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6))
        };
        ListNode result = solution.mergeKLists(lists);
        // Print the merged list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        } // Output: 1 1 2 3 4 4 5 6
    }
}

class MyComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode first, ListNode second) {
        if (first.val == second.val) {
            return 0;
        }
        return first.val < second.val ? -1 : 1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
