import java.util.LinkedList;
import java.util.Queue;

/**
 * TreeNode
 */
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode() {}
    public TreeNode(int value) { this.val = value; }
    public TreeNode(int value, TreeNode left, TreeNode right) { this.val = value; this.left = left; this.right = right; }
}

enum Position {
    ROOT,
    LEFT,
    RIGHT
}


record TreeNodePlus(int val, Position pos, TreeNode left, TreeNode right) {}

/**
 * BTree
 */
public class BTree {
    TreeNode root;

    public BTree() {}
    public BTree(TreeNode root) { this.root = root; }

    // Прямой обход (NLR)
    public void nlr(TreeNode node) {
        if (node == null) return;
        
        visit(node);
        nlr(node.left);
        nlr(node.right);
    }
    
    // inorder обход (Центрированный обход)
    public void lnr(TreeNode node) {
        if (node == null) return;
        
        lnr(node.left);
        visit(node);
        lnr(node.right);
    }
    
    // Обратный обход (LRN)
    public void lrn(TreeNode node) {
        if (node == null) return;
        
        lrn(node.left);
        lrn(node.right);
        visit(node);
    }

    // Обход в ширину (breadth-first search, BFS)
    public void bfs() {
        if (this.root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (node == null) continue;
            
            visit(node);
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    private void visit(TreeNode node) {
        System.out.printf("%d ", node.val);
    }

    private void visualize() {
        if (this.root == null) { System.out.println("Tree is empty!"); return; }

        Queue<TreeNodePlus> queue = new LinkedList<TreeNodePlus>();
        queue.add(new TreeNodePlus(this.root.val, Position.ROOT, this.root.left, this.root.right));

        int gap = 10;

        while (!queue.isEmpty()) {
            TreeNodePlus node = queue.remove();

            if (node == null) continue;

            for (int i = 0; i < gap; i++) { System.out.print(" "); }

            switch (node.pos()) {
               	case ROOT:  		
                    System.out.printf("%d\n", node.val());
                    for (int i = 0; i < gap - 1; i++) { System.out.print(" "); }
                    System.err.println("/ \\");
              		break;
                            
               	case LEFT:
                    System.out.printf("%d", node.val());
              		break;
                
               	case RIGHT:
                    System.out.printf("  %d\n", node.val());
                    // for (int i = 0; i < gap - 1; i++) { System.out.print(" "); }
                    System.err.println("  / \\");
              		break;
            }
            
            queue.add(new TreeNodePlus(node.left().val, Position.LEFT, node.left().left, node.left().right));
            queue.add(new TreeNodePlus(node.right().val, Position.RIGHT, node.right().left, node.right().right));
            gap -= 2;
        }
            
    }

    public static void main(String[] args) {
        //     5
        //    / \
        //   4   7
        //  / \
        // 1   2

        TreeNode node5 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        node3.left = node4;
        node3.right = node5;
        TreeNode node2 = new TreeNode(7);
        TreeNode node1 = new TreeNode(5, node3, node2);

        // TreeNode node3 = new TreeNode(3);
        // TreeNode node2 = new TreeNode(2);
        // TreeNode node1 = new TreeNode(1);
        // node1.right = node2;
        // node2.left = node3;
        
        BTree tree = new BTree(node1);

        tree.lnr(tree.root);
        System.out.println();

        tree.bfs();
        System.out.println();

        tree.visualize();
    }
}