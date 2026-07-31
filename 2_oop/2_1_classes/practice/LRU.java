package practice;

import java.util.HashMap;

class Node {
    public int value;
    public Node next;
    public Node prev;
    public int key;

    public Node() {}
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRU { // based on 2 way linked list
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> items;
    
    public LRU(int capacity) {
        this.head = new Node();
        this.tail = new Node();

        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
        this.items = new HashMap<Integer, Node>();
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.items.remove(node.key);
    }

    private Node addToHead(int key, int value) {
        Node node = new Node(key, value);
        node.next = this.head.next;
        node.prev = this.head;
        
        node.next.prev = node;
        this.head.next = node;

        this.items.put(key, node);

        return node;
    }
    
    public int get(int key) {
        Node item = this.items.get(key);
       
        if (item == null) return -1;

        remove(item);
        Node node = addToHead(item.key, item.value);
        return node.value;
    }
    
    public void put(int key, int value) {
        // Сначала проверяем дубли ключей, если есть, то заменить
        if (this.items.containsKey(key)) {
            Node node = this.items.get(key);
            remove(node);
            Node item = addToHead(key, value);
            return;
        }

        // Проверяем выход за пределы емкости
        if (this.items.size() >= this.capacity) {
            remove(this.tail.prev);
            Node item = addToHead(key, value);
            return;
        }
        
        Node item = addToHead(key, value);
    }

    public void show() {
        System.out.print("head <-> ");
        Node current = this.head.next;

        while (current.next != null) {
            System.out.printf("%d <-> ", current.value);
            current = current.next;
        }

        System.out.println("tail");
    }

    public static void main(String[] args) {
        // [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        LRU cache = new LRU(2);
        cache.show();
        
        // cache.put(1, 1);
        // cache.put(2, 2);
        // cache.show();
    
        // int item = cache.get(1);
        // cache.show();
        
        // cache.put(3, 3);
        // cache.show();
        
        // int item2 = cache.get(2);
        // cache.show();
        
        // cache.put(4, 4);
        // cache.show();
    
    
        // [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        var item3 = cache.get(2);
        cache.show();
        
        cache.put(2, 6);
        cache.show();
    
        var item4 = cache.get(1);
        cache.show();
        
        cache.put(1, 5);
        cache.put(1, 2);
        cache.show();
    
        var item5 = cache.get(1);
        cache.show();
        
        var item6 = cache.get(2);
        cache.show();
    }
}
