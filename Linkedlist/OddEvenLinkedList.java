import java.util.*;

// solution for 328. Odd Even Linked List
// leetcode submission: https://leetcode.com/problems/odd-even-linked-list/submissions/1442503177
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // odd is the head of the odd nodes, and even is the head of the even nodes
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        evenHead = even;
    
        // loop through the list to find the odd and even nodes
        while (even != null && even.next != null) {
            // odd.next is the next odd node
            odd.next = even.next;
            // move odd to the next odd node
            odd = odd.next;
            // even.next is the next even node
            even.next = odd.next;
            // move even to the next even node
            even = even.next;
        }

        // connect the odd nodes to the even nodes
        odd.next = evenHead;
        return head;   
    }

    public static void main(String[] Args) {
        // test case 
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // call the reverse method
        OddEvenLinkedList sol = new OddEvenLinkedList();
        ListNode result = sol.oddEvenList(head);
        // print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        } // Output: 1 3 5 2 4
    }
}
