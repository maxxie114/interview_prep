package Linkedlist;

public class leetcode876 {
    if (head == null) {
        return null
      }
      set listnode slow = head
      set listnode fast = head
      
      while(fast is not null && fast.next is not null) {
          slow = slow.next
          fast = fast.next.next
      }
      
      return slow
}
