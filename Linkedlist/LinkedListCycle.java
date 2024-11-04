import java.util.*;

// Solution for leetcode 141
// leetcode submission: https://leetcode.com/problems/linked-list-cycle/submissions/1442440622/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // edge cases
        if (head == null) {
            return false;
        }

        // declare a slow and fast pointer
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // move slow pointer by 1 step and fast pointer by 2 steps
            slow = slow.next;
            fast = fast.next.next;

            // if slow and fast pointer meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // test case
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        // create a cycle
        head.next.next.next.next = head.next;
        LinkedListCycle solution = new LinkedListCycle();
        System.out.println(solution.hasCycle(head)); // expect true
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}