public class Program {
    public static void main(String[] args) {
        Node node = new Node();
        Node parent = new Node();

        node.parent = parent;

        node.currentPosition();

        System.out.println("Walking up:");
        node.walkUp();
    }
}

class Node {
    Node parent;
    Node next;

    public void currentPosition() {
        System.out.printf("%s <- Node <- %s\n", parent, next);
    }

    public void walkUp() {
        Node currentNode = this;
        do {
            System.out.println(currentNode);
            currentNode = parent;
        } while (currentNode.parent != null);
    }
}