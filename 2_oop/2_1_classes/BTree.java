import java.util.ArrayList;
import java.util.List;

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

/**
 * BTree
 */
public class BTree {
    TreeNode root;

    public BTree() {}
    public BTree(TreeNode root) { this.root = root; }

    public void show() {
        if (this.root == null) { System.out.println("Tree is empty!"); return; }
        lnr(this.root);
    }

    // Прямой обход (NLR)
    private void nlr(TreeNode node) {
        if (node == null) return;
        
        visit(node);
        nlr(node.left);
        nlr(node.right);
    }
    
    // inorder обход (Центрированный обход)
    private void lnr(TreeNode node) {
        if (node == null) return;
        
        lnr(node.left);
        visit(node);
        lnr(node.right);
    }

    
    // Обратный обход (LRN)
    private void lrn(TreeNode node) {
        if (node == null) return;
        
        lrn(node.left);
        lrn(node.right);
        visit(node);
    }

    private void visit(TreeNode node) {
        System.out.printf("%d ", node.val);
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

        tree.show();
    }
}