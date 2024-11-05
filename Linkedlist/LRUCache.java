import java.util.*;

// Solution for leetcode 146
// leetcode submission: https://leetcode.com/problems/lru-cache/submissions/1443541501
public class LRUCache {
    // Initialize the hashmap, linkedlist, and capacity
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    // initialize the linkedlist
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    // get: get the node, move to the front, and return the node, if I can't get that node, return -1
    public int get(int key) {
        // get the node from the map, and move it to the front
        Node node = map.get(key);
        moveToFirst(node);

        // if the node is not in the map, return -1
        if (node == null) {
            return -1;
        }

        // return the value of the node
        return node.getValue();
    }
    
    // put: if key exist, update the node, if it doesn't exist, create a new node and add to first, and then removeLast
    public void put(int key, int value) {
        // if the key exists, update the value and move to the front
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFirst(node);
        } else {
            // if the key doesn't exist, create a new node and add to the front
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToFirst(newNode);

            // if the capacity is full, remove the last node
            if (map.size() > capacity) {
                removeLast();
            }
        }
    }
    
    
    // Move the node to the front
    void moveToFirst(Node curNode) {
        // edge case: if the current node is null, or the current node is the head, return
        if (curNode == null || curNode == head) {
            return;
        }

        // if the current node is not null, point the next node to the previous node
        if (curNode.next != null) {
            curNode.next.prev = curNode.prev;
        }

        // if the node is not null, point the previous node to the next node
        if (curNode.prev != null) {
            curNode.prev.next = curNode.next;
        }

        // point the current node to the head
        curNode.next = head.next;
        curNode.prev = head;

        // if the head is not null, point the previous node to the current node
        if (head.next != null) {
            head.next.prev = curNode;
        }

        head.next = curNode; 
    }

    // remove the last node
    void removeLast() {
        // get the last node and remove it from the map
        Node lastNode = tail.prev;
        map.remove(tail.prev.getKey());

        // if the last node is not null, point the next node to the tail
        if (lastNode.prev != null) {
            lastNode.prev.next = tail;
            tail.prev = lastNode.prev;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node() {}    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    
    public int getKey() {
        return key;
    }
    
    public int getValue() {
        return value;
    }
}
