import java.util.*;

// Solution for leetcode 146: LRU Cache
// Submission: https://leetcode.com/problems/lru-cache/submissions/1471551857
class LRUCache {
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.head = new Node();
        this.tail = new Node();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToFirst(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // put the item in the front if it doesn't exist
        if (!map.containsKey(key)) {
            Node cur = new Node(key, value);
            // Mannually insert the node into the linkedlist
            cur.next = head.next;
            cur.prev = head;
            head.next = cur;
            cur.next.prev = cur;

            map.put(key, cur);
        }
        // if the key exist already, update value
        else {
            Node cur = map.get(key);
            cur.value = value;
            moveToFirst(cur);
        }
        // remove the one at the tail if it is over the capacity
        if (map.size() > capacity) {
            removeLast();
        }    
    }

    public void moveToFirst(Node node) {
        // move the node to the front
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeLast() {
        // remove the one at the tail
        if (tail.prev != head) {
            Node last = tail.prev;
            last.prev.next = tail;
            tail.prev = last.prev;
            map.remove(last.key);
        }
    }

    public static void main(String[] args) {
        // test case
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2
        System.out.println(lruCache.get(5)); // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
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