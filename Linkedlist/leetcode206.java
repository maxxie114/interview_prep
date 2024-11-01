package Linkedlinst;

// iterative
public class leetcode206 {
    if head == null {
        return head
    }
      
    prev = null
    cur = head
    next = head
    
    while  cur == null {
        next = cur.next
        cur.next = prev
        prev = cur
        cur = next
    }
    
    return prev
}
