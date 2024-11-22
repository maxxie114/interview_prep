import java.util.*;

// Solution for leetcode 148: quick sort
// Leetcode submission: https://leetcode.com/problems/sort-list/submissions/1460164802
// This submission passed 29/31 test cases, but failed on the last case due to time limit exceeded
public class ListSortingQuickSort {
    public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }
    
    private ListNode quickSort(ListNode head, ListNode end) {
        if (head != end) {
            // Partition the list and get the pivot position
            ListNode pivot = partition(head, end);
            quickSort(head, pivot);
            quickSort(pivot.next, end);
        }
        return head;
    }

    private ListNode partition(ListNode head, ListNode end) {
        int pivotVal = head.val;
        ListNode slow = head, fast = head.next;
        
        while (fast != end) {
            if (fast.val < pivotVal) {
                slow = slow.next;
                // Swap values
                int temp = slow.val;
                slow.val = fast.val;
                fast.val = temp;
            }
            fast = fast.next;
        }

        // Swap head with slow
        int temp = slow.val;
        slow.val = head.val;
        head.val = temp;
        
        return slow;
    }
}
