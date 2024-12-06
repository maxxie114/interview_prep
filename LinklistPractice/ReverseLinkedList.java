// Solution for leetcode 206. Reverse Linked List
// Submission: https://leetcode.com/problems/reverse-linked-list/submissions/1472158922
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // edge case
        if (head == null) {
            return null;
        }

        // base case
        if (head.next == null) {
            return head;
        }

        // recursive case
        // reverse the list from the head by pointing the next node to the head
        ListNode curHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curHead;
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