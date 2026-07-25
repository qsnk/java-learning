public class Program {
    public static void main(String[] args) {
        Node parent = new Node();
        Node node = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        parent.parent = null;
        parent.next = node;
        
        node.parent = parent;
        node.next = node2;

        node2.parent = node;
        node2.next = node3;

        node3.parent = node2;
        node3.next = null;

        node.currentPosition();
        System.out.println();

        node.displayParentInfo();
        node.displayChildInfo();
        node.displayFromCurrent();
    }
}

class Node {
    private String name;
    Node parent;
    Node next;

    public int parentCount() {
        int counter = 0;
        Node currentNode = this;
        
        while (currentNode.parent != null) {
            counter++;
            currentNode = currentNode.parent;
        }

        return counter;
    }
    
    public int childCount() {
        int counter = 0;
        Node currentNode = this;
        
        while (currentNode.next != null) {
            counter++;
            currentNode = currentNode.next;
        }

        return counter;
    }

    public void currentPosition() {
        System.out.printf("%s (parent) <-- %s (this) --> %s (next)\n", parent, this, next);
    }

    public void displayFromCurrent() {
        Node currentNode = this;
        System.out.print("(this) ");
        
        while (currentNode != null) {
            if (currentNode.next == null) {
                System.out.printf("%s (last)\n", currentNode);
                break;
            }
            
            System.out.printf("%s --> ", currentNode);
            currentNode = currentNode.next;
        }
    }

    public void displayParentInfo() {
        System.out.printf("%s has %d parent nodes\n", this, this.parentCount());
    }
    
    public void displayChildInfo() {
        System.out.printf("%s has %d child nodes\n", this, this.childCount());
    }
}