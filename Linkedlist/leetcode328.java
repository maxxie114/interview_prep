package Linkedlinst;

public class leetcode328 {
    if head == null return null
    odd = head
    even = head.next
    evenHead= head.next
    evenHead = even

    while even is not null and even.next is not null {
        odd.next = even.next
        odd = odd.next
        even.next = odd.next
        even = even.next
    }
    odd.next = evenHead
    return head
}
