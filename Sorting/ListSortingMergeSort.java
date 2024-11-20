import java.util.*;

// solution for leetcode 148: merge sort
// Leetcode submission: https://leetcode.com/problems/sort-list/submissions/1457831207
public class ListSortingMergeSort {
    public ListNode sortList(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }

        // find the middle of the list, and cut the list into two halves
        ListNode mid = getMiddle(head);
        ListNode right = mid.next;
        mid.next = null;

        // recursively sort the two halves
        ListNode left = sortList(head);
        right = sortList(right);

        // merge the two sorted halves
        return merge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        // Get middle using fast and slow pointers
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted lists
    private ListNode merge(ListNode left, ListNode right) {
        // corner case
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        // if there are any remaining nodes in the left list
        if (left != null) {
            cur.next = left;
        }
        // if there are any remaining nodes in the right list
        if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }

    public static void main(String[] Args) {
        // test case
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListSortingMergeSort test = new ListSortingMergeSort();
        ListNode result = test.sortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
