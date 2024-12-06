// Solution for leetcode 876: Middle of the Linked List
// Solution: https://leetcode.com/problems/middle-of-the-linked-list/submissions/1472160527
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // edge case
        if (head == null) {
            return null;
        }

        // create a slow fast pointer
        ListNode slow = head;
        ListNode fast = head;

        // move the fast pointer twice as fast as the slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // return the slow pointer as the middle of the linked list
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}
