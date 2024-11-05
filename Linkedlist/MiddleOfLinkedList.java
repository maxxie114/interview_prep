import java.util.*;

// Solution for leetcode 876
// Leetcode submission: https://leetcode.com/problems/middle-of-the-linked-list/submissions/1443548404
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // edge case: if head is null, return null
        if (head == null) {
            return null;
        }

        // initialize the slow and fast pointer
        ListNode slow = head;
        ListNode fast = head;
        
        // move the fast pointer twice as fast as the slow pointer
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    public static void main(String[] Args) {
        // test case
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // get the middle node 
        MiddleOfLinkedList sol = new MiddleOfLinkedList();
        ListNode middle = sol.middleNode(head);
        // print the linked list from the middle node
        while(middle != null) {
            System.out.print(middle.val + " "); // 3 4 5
            middle = middle.next;
        }
    }
}
