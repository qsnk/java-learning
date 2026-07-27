public class Program {
    public static void main(String[] args) {
        NodeList list = new NodeList();
        list.display();

        list.insert("Node1");
        list.display();
        
        list.insert("Node2");
        list.display(); 
        
        list.insert("Node3");
        list.display();        

        list.remove(2);
        list.display();
        System.out.println(list.getTail().toString());

        list.insert("Node4");
        list.display();
        
        System.out.println();
        list.displayTree();
    }
}

class OneWayNode {
    String value;
    OneWayNode next;

    OneWayNode (String value) {
        this.value = value;
    }

    // @Override
    // public String toString() {
    //     return this.value;
    // }
}

// 1-связный список (head -> node -> tail)
class NodeList {
    OneWayNode head;
    
    // Конструкторы
    NodeList () {}    

    NodeList (String value) {
        this.head = new OneWayNode(value);
    }

    public int length() {
        if (this.head == null) return 0;

        int counter = 1;
        OneWayNode current = this.head;
 
        while (current.next != null) {
            counter++;
            current = current.next;
        }

        return counter;
    }

    public OneWayNode getTail() {
        OneWayNode tail = this.head;

        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public void insert(String value) {
        if (this.head == null) {
            this.head = new OneWayNode(value);
            return;
        }

        OneWayNode tail = getTail();
        tail.next = new OneWayNode(value);
    }

    public void remove(int index) {
        if (index > length() || index < 0) throw new IndexOutOfBoundsException("Index out of range");

        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        
        int currentIndex = 1;
        OneWayNode prevNode = this.head;
        OneWayNode currentNode = this.head.next;

        while (currentIndex != index) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }

        OneWayNode tail = getTail();
        if (currentNode.equals(tail)) {
            prevNode.next = null;
        } else {
            prevNode.next = currentNode.next;
        }
    }    
    
    public void display() {
        if (length() == 0) {
            System.out.println("Nothing to display. List is empty!");
            return;
        }
        
        OneWayNode current = this.head;

        while (current.next != null) {
            System.out.printf("%s(%s) -> ", current, current.value);
            current = current.next;
        }

        System.out.printf("%s(%s)\n", current, current.value);
    }

    public void displayTree() {
        if (length() == 0) {
            System.out.println("Nothing to display. List is empty!");
        }

        OneWayNode current = this.head;
        int offset = 0;

        while (current.next != null) {
            System.out.printf("%s(%s)\n", current, current.value);
            
            for (int i = 0; i < offset; i++) { System.out.print("    "); }
            System.out.print("└── ");

            current = current.next;
            offset++;
        }

        System.out.printf("%s(%s)\n", current, current.value);
    }
}