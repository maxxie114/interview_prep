import java.util.*;

// Solution for leetcode 206, recursive method
// leetcode solution: https://leetcode.com/problems/reverse-linked-list/submissions/1442463290
public class ReverseLinkedListRecursion {
    public ListNode reverseList(ListNode head) {
        // edge case
        if (head == null) {
            return null;
        }
        
        // recursion base case, if head.next is null, that means head is the last node
        // return head as the new head
        if (head.next == null) {
            return head;
        }
        
        // recursion rule
        // other cases, reverse the linkedlist from head.next
        ListNode resultHead = reverseList(head.next);
        head.next.next = head;
        // set head.next to null to avoid cycle
        head.next = null;
        return resultHead;
    }

    public static void main(String[] args) {
        // test case
        ReverseLinkedListRecursion sol = new ReverseLinkedListRecursion();
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
