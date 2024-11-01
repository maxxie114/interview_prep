package Linkedlinst;

public class leetcode141 {
    boolean hasCycle() {
        if head == null {
            return false
        }

        listnode slow = head
        listnode fast = head

        while fast is not null and fast.next is not null {
            slow = slow.next
            fast = fast.next.next

            if slow == fast {
                return true
            }
        }
        return false
    }
}
