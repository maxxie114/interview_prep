package Linkedlist;

public class leetcode25 {
    if head == null or k == 1 return head

    groupHead = head
    groupTail = head
    count = 1
    while coun t < k && groupTail.next is not null {
      groupTail = groupTail.next
      count++
    }
    if count < k return groupHead
    
    prev = null
    next = groupHead.next
    while prev != groupTail {
      if prev == null grouphead.next = reverseKGroup(grouptail.next, k)
      else grouphead.next = prev
      prev = groupHead
      groupHead = next
      if next != null next = next.next
    }
}
