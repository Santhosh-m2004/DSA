package leetcode;

public class lt543 {

    static class TreeNode {
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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int diam1 = height(root.left) + height(root.right);
        int diam2 = diameterOfBinaryTree(root.left);
        int diam3 = diameterOfBinaryTree(root.right);

        return Math.max(diam1, Math.max(diam2, diam3));
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        lt543 obj = new lt543();

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Expected diameter = 3 (path: 4 → 2 → 1 → 3)
        int result = obj.diameterOfBinaryTree(root);
        System.out.println("Diameter of Binary Tree: " + result);
    }
}
