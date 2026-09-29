import java.util.HashMap;

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LruCache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {

        // If key already exists
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);

            existingNode.value = value;

            remove(existingNode);
            addToHead(existingNode);
        }

        // If key does not exist
        else {
            // Remove least recently used node
            if (cache.size() >= capacity) {
                Node lru = tail.prev;

                cache.remove(lru.key);
                remove(lru);
            }

            Node newNode = new Node(key, value);

            cache.put(key, newNode);
            addToHead(newNode);
        }
    }

    public int get(int key) {

        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);

            // Move accessed node to front
            remove(existingNode);
            addToHead(existingNode);

            return existingNode.value;
        }

        return -1;
    }

    // Remove node from linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node just after head
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

public class LeastRecentlyUsedCache {

    public static void main(String[] args) {

        LruCache lruCache = new LruCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);

        System.out.println(lruCache.get(1)); // 1

        lruCache.put(3, 3); // evicts key 2

        System.out.println(lruCache.get(2)); // -1

        lruCache.put(4, 4); // evicts key 1

        System.out.println(lruCache.get(1)); // -1
        System.out.println(lruCache.get(3)); // 3
        System.out.println(lruCache.get(4)); // 4
    }
}