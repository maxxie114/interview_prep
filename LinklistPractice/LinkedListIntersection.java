import java.util.*;
// Solution for leetcode 160: Intersection of Two Linked Lists
// Submission: https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/1472165549
public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // base case
        if (headA == null || headB == null) {
            return null;
        }

        // Create a hashset
        HashSet<ListNode> set = new HashSet<ListNode>();
        
        // Traverse through the first linked list and add the nodes to the hashmap
        // Do not check headA.next != null, because we want to add the last node as well
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        // Traverse through the second linkedlist and check overlap
        // Same thing here, do not check headB.next != null
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
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