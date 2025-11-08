package leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { 
        this.val = val; 
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class lt700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        lt700 obj = new lt700();
        int val = 2;
        TreeNode result = obj.searchBST(root, val);

        if (result != null) {
            System.out.println("Node found with value: " + result.val);
            if (result.left != null) System.out.println("Left child: " + result.left.val);
            if (result.right != null) System.out.println("Right child: " + result.right.val);
        } else {
            System.out.println("Value " + val + " not found in the BST.");
        }
    }
}
