package meta.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache — LeetCode #146 (Medium)
 *
 * <p><b>Problem:</b> Design a cache with a fixed capacity that evicts the
 * Least Recently Used (LRU) entry when it is full.
 *
 * <p><b>Concept:</b> Combines a doubly-linked list (to track recency order in O(1))
 * with a HashMap (for O(1) key lookup). Together they give O(1) get and put.
 *
 * <p><b>Real-world relevance:</b> LRU is a production cache eviction policy used in
 * Redis, OS page replacement, CPU caches, and web CDN edge nodes. Java's
 * {@code LinkedHashMap} provides the same semantics out-of-the-box.
 *
 * <p><b>Design choices:</b>
 * <ul>
 *   <li>Sentinel {@code head} and {@code tail} nodes eliminate edge-case null checks.</li>
 *   <li>Moving a node on every {@code get} keeps "most-recently-used" always near
 *       {@code tail}, so eviction simply removes {@code head.next}.</li>
 * </ul>
 *
 * <p>Time: O(1) for both get and put | Space: O(capacity)
 */
public class LRUCache {
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> dictionary;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        dictionary = new HashMap();
    }

    public int get(int key) {// Return the value of the key if the key exists, otherwise return -1.
        if (!dictionary.containsKey(key)) {
            return -1;
        }
        Node node = dictionary.get(key);
        remove(node);
        add(node);
        return node.val;
    }


    public void put(int key, int value) {// Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
        if (dictionary.containsKey(key)) {
            Node oldNode = dictionary.get(key);
            remove(oldNode);
        }
        Node node = new Node(key, value);
        dictionary.put(key, node);
        add(node);
        if (dictionary.size() > capacity) {
            Node firstNode = head.next;
            remove(firstNode);
            dictionary.remove(firstNode);
        }
    }

    private void add(Node node) {
        Node prevEnd = tail.prev;
        prevEnd.next = node;
        node.next = tail;
        node.prev = prevEnd;
        tail.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

// Time complexity --get : O(1)  --put : O(1)
// Space Complexity :O(N)