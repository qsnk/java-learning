public class Program {
    public static void main(String[] args) {
        Default def = new Default();
        def.display();
        
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

        System.out.println("\n");
        NodeList2 list2 = new NodeList2("Node1");
        list2.display();

        list2.insert("Node2");
        list2.display();
        
        list2.insert("Node3");
        list2.display();   
        
        list2.insert("Node4");
        list2.display();

        list2.remove(2);
        list2.display();

        try {
            list2.remove(999);
        } catch (IndexOutOfBoundsException e) {
            System.err.printf("Failed to remove node: %s", e.getMessage());
        }
    }
}

// Какие значения по умолчанию имееют поля
class Default {
    byte byteValue;
    short shortValue;
    int intValue;
    long longValue;
    float floatValue;
    double doubleValue;
    char charValue; // '\u0000' - null character
    String strValue;
    boolean boolValue;

    int[] intArr;
    String[] strArr;

    public void display() {
        System.out.println("Значения по умолчанию:");
        System.out.println("byte = " + this.byteValue);
        System.out.println("short = " + this.shortValue);
        System.out.println("int = " + this.intValue);
        System.out.println("long = " + this.longValue);
        System.out.println("float = " + this.floatValue);
        System.out.println("double = " + this.doubleValue);
        System.out.println("char = " + this.charValue);
        System.out.println("String = " + this.strValue);
        System.out.println("boolean = " + this.boolValue);
        System.out.println("int array = " + this.intArr);
        System.out.println("String array = " + this.strArr);
        System.out.println();
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

class TwoWayNode {
    String value;
    TwoWayNode prev;
    TwoWayNode next;

    TwoWayNode(String value) {
        this.value = value;
    }
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
            current = current.next;
            counter++;
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
        if (index >= length() || index < 0) throw new IndexOutOfBoundsException("Index out of range");

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

        prevNode.next = currentNode.next;
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

// 2-связный список (head <-> node <-> tail)
class NodeList2 {
    TwoWayNode head;

    NodeList2() {}

    NodeList2(String value) {
        this.head = new TwoWayNode(value);
    }

    public int length() {
        if (this.head == null) return 0;

        TwoWayNode current = this.head;
        int counter = 1;
        while (current.next != null) {
            current = current.next;
            counter++;
        }

        return counter;
    }

    public TwoWayNode getTail() {
        TwoWayNode current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    public void insert(String value) {
        if (this.head == null) {
            this.head = new TwoWayNode(value);
            return;
        }

        TwoWayNode tail = getTail();
        TwoWayNode node = new TwoWayNode(value);

        tail.next = node;
        node.prev = tail;
    }

    public void remove(int index) {
        if (index >= length() || index < 0) throw new IndexOutOfBoundsException("Index out of range");

        if (index == 0) {
            this.head = this.head.next;
            return;
        }

        int currentIndex = 1;
        TwoWayNode prevNode = this.head;
        TwoWayNode currentNode = this.head.next;

        while (currentIndex != index) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }

        prevNode.next = currentNode.next;
        currentNode.next.prev = prevNode;
    }

    public void display() {
        if (length() == 0) {
            System.out.println("Nothing to display. List is empty!");
        }

        TwoWayNode current = this.head;

        while (current.next != null) {
            System.out.printf("%s (%s) <-> ", current, current.value);
            current = current.next;
        }

        System.out.printf("%s (%s)\n", current, current.value);
    }
}
