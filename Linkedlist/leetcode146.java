package Linkedlinst;

public class leetcode146 {
    // get: get the node, move to the front, and return the node, if I can't get that node, return -1
    // put: if key exist, update the node, if it doesn't exist, create a new node and add to first, and then removeLast

    void moveToFirst(curNode) {
        if curnode.next is not null {
            curnode.next.prev = curnode.prev
        }	
        if curnode.prev is not null {
            curnode.prev.next = curnode.next
        }
        curnode.next = head.next
        curnode.prev = head
        head.next = curnode
        curnode.next.prev  = curnode
    }

    void removeLast() {
        lastnode = tail.prev
        map.remove(tail.prev.getkey)
        if lastnode.prev is not null {
            lastnode.prev.next = tail
            tail.prev = lastnode.prev
        }
    }
}
