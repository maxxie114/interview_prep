import java.util.*;

// solution for leetcode 92
// leetcode submission: https://leetcode.com/problems/reverse-linked-list-ii/submissions/1442485961
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        
        // Create a dummy node to handle the case when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode oneBeforeReverse = dummy;
        
        // Move oneBeforeReverse to the node before the left position
        for (int i = 1; i < left; i++) {
            oneBeforeReverse = oneBeforeReverse.next;
        }
        
        ListNode startOfReverse = oneBeforeReverse.next;
        ListNode cur = startOfReverse;
        ListNode prev = null;
        ListNode next = null;
        
        // Reverse the portion of the linked list
        for (int i = 0; i <= right - left; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        // Connect oneBeforeReverse to the new head of the reversed sublist
        oneBeforeReverse.next = prev;
        // Connect the end of the reversed sublist to the remaining part of the list
        startOfReverse.next = cur;
        
        return dummy.next;
    }

    public static void main(String[] Args) {
        // test case
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // reverse between 2 and 4
        ReverseLinkedList2 sol = new ReverseLinkedList2();
        ListNode result = sol.reverseBetween(head, 2, 4);
        // expected output: 1 -> 4 -> 3 -> 2 -> 5
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
