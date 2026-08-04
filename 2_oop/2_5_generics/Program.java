public class Program {
    public static void main(String[] args) {
        Node<Integer> node3 = new Node<Integer>(4);
        Node<Integer> node2 = new Node<Integer>(3, node3);
        Node<Integer> node1 = new Node<Integer>(1, node2);
        NodeList<Integer> list = new NodeList<Integer>(node1);
        list.show();

        list.remove(1);
        list.show();

        list.put(6);
        list.put(9);
        list.show();

        Node<String> node6 = new Node<String>("v4");
        Node<String> node5 = new Node<String>("v3", node6);
        Node<String> node4 = new Node<String>("v1", node5);
        NodeList<String> list2 = new NodeList<String>(node4);
        list2.show();

        list2.remove(0);
        list2.show();
    }
}

class Node<T> {
    T val;
	Node<T> next;

	public Node() {}
	public Node(T value) { this.val = value; }
	public Node(T value, Node<T> next) { this.val = value; this.next = next; }
}

class NodeList<T> {
    Node<T> head;

    public NodeList() {}
    public NodeList(Node<T> head) { this.head = head; }

    private int length() {
        Node<T> current = this.head;
        int counter = 0;
        
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }
    
    public void put(T value) {
        Node<T> current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node<T>(value);
    }
    
    public void remove(int index) {
        if (index < 0 || index >= length()) throw new IndexOutOfBoundsException("Index out of bounds");
        if (index == 0) { this.head = this.head.next; return; }
        
        Node<T> current = this.head;
        Node<T> prev = current;
        int currentIndex = 0;

        while (currentIndex != index) {
            prev = current;
            current = current.next;
            currentIndex++;
        }

        prev.next = current.next;
    }

    public void show() {
        Node<T> current = this.head;
        
        while (current.next != null) {
            System.out.printf("%s -> ", current.val);
            current = current.next;
        }
        System.out.println(current.val);
    }
}