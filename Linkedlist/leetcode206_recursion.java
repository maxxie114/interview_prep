package Linkedlinst;

public class leetcode206_recursion {
    // corner
    if head == null {
        return null
    }
    
    // recursion base head
    if head.next == null {
        return head
    }
    
    // recursion rule
    resultHead = reverseList(head.next)
    head.next.next = head
    head.next = null
    return resultHead
}
