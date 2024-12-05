import java.util.*;

// Solution for leetcode 146: LRU Cache
class LRUCache {
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.head = new Node();
        this.tail = new Node();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        Hashmap<Integer, Node> map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.get(key)) {
            Node cur = map.get(key);
            cur.next.next = cur.prev;
            cur.prev.next = cur.next;
            cur.next = head;
            cur.prev = null;
            return cur.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
    }

    public void moveToFirst(Node node) {

    }

    public void removeLast(Node node) {
        
    }
}

class Node {
    Node next, prev;
    int key, value;
    public Node() {}
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    } 
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 /*
 size2
 [1,1],[2,2]
 [2,2],[1,1]
 [3,3],[2,2]

 get():
 1. get that item from the cache
 2. move it to the front
 3. set head to that node
 4. update tail

 put():
 1. put the item in the front if it doesn't exist, set the head to it
 2. if the key exist already, get this from the hashmap, update the key value, move it to the front, update the head
 3. remove the one at the tail, update the tail to the one before it. (if the size of the hashmap is over 2)


{1:[1,1],3:[3,3]}

[3,2]<->[1,1]<->[2,2]
h
          t.next.prev = null        

node.next.next = node.prev
node.prev.next = node.next
node.next = head
node.prev = null
*/