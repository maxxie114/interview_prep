import java.util.*;

// Solution for leetcode 25
// leetcode submission: https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/1443520007
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // edge case: if head is null or k is 1, return head
        if (head == null || k == 1) {
            return head;
        }

        // initialize groupHead and groupTail
        ListNode groupHead = head;
        ListNode groupTail = head;
        int count = 1;

        // find the groupTail by moving k steps
        while (count < k && groupTail.next != null) {
            groupTail = groupTail.next;
            count++;
        }

        // base case: if count < k, return groupHead
        if (count < k) {
            return groupHead;
        }
        
        // initialize prev and next
        ListNode prev = null;
        ListNode next = groupHead.next;

        // recursion case: reverse the group and connect the group to the previous group
        while (prev != groupTail) {
            // if prev is null, connect the group to the next group
            if (prev == null) {
                groupHead.next = reverseKGroup(groupTail.next, k);
            // if prev is not null, connect the group to the previous group
            } else {
                groupHead.next = prev;
            } 

            // move to the next node
            prev = groupHead;
            groupHead = next;

            // if next is not null, move to the next node
            if (next != null) {
                next = next.next;
            }
        }
        // return the reversed group
        return groupTail;
    }

    public static void main(String[] Args) {
        // test case
        ReverseKGroup test = new ReverseKGroup();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode result = test.reverseKGroup(head, 2);
        while (result != null) {
            System.out.print(result.val + " "); // expect 2, 1, 4, 3, 5
            result = result.next;
        }
    }
}
