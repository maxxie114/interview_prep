import java.util.*;

// iterative solution for leetcode 206
// leetcode submission: https://leetcode.com/problems/reverse-linked-list/submissions/1442456383
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // edge case
        if (head == null) {
            return head;
        }
        
        // create prev, cur, next
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        
        // reverse the linkedlist
        while  (cur != null) {
            // move next to next node
            // move cur to prev node
            // move prev to cur node
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev; // prev is the new head
    }

    public static void main(String[] args) {
        // test case
        ReverseLinkedList sol = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = sol.reverseList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        } // expect 5 4 3 2 1
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
