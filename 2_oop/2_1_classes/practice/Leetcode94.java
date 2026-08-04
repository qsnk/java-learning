import java.util.ArrayList;
import java.util.List;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> items = new ArrayList<Integer>();
        lnr(items, root);
        return items;
    }

    private void lnr(List<Integer> list, TreeNode node) {
        if (node == null) return;
        
        // inorder обход (Центрированный обход (LNR)
        lnr(list, node.left);
        visit(list, node);
        lnr(list, node.right);
    }

    private void visit(List<Integer> list, TreeNode item) { list.add(item.val); }
}