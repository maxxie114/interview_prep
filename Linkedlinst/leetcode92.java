package Linkedlinst;

public class leetcode92 {
    if head == null{
        return null
      }
      if left == right {
       return head
      }
      
      oneBeforeReverse
      startOfReverse
      cur 
      next
      
      int timesToReverse = right - left + 1
      while  timesToReverse > 0 {
        next = cur.next
        cur.next = prev
        prev = cur
        cur = next
        timesToReverse--;
      }
      
      oneBeforeReverse -> prev      
}
