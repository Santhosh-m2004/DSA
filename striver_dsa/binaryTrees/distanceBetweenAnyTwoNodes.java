package binaryTrees;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class distanceBetweenAnyTwoNodes {
    
    // Step 1: Find LCA of two nodes
    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null) return null;
        if (root.val == n1 || root.val == n2) return root;

        TreeNode left = findLCA(root.left, n1, n2);
        TreeNode right = findLCA(root.right, n1, n2);

        if (left != null && right != null) return root; // both sides found
        return (left != null) ? left : right;
    }

    // Step 2: Find distance from root to given node
    public int findDistanceFromRoot(TreeNode root, int target) {
        if (root == null) return -1;
        if (root.val == target) return 0;

        int left = findDistanceFromRoot(root.left, target);
        if (left != -1) return left + 1;

        int right = findDistanceFromRoot(root.right, target);
        if (right != -1) return right + 1;

        return -1;
    }

    // Step 3: Get distance between two nodes
    public int findDistance(TreeNode root, int n1, int n2) {
        TreeNode lca = findLCA(root, n1, n2);
        int d1 = findDistanceFromRoot(lca, n1);
        int d2 = findDistanceFromRoot(lca, n2);
        return d1 + d2;
    }

    // Example usage
    public static void main(String[] args) {
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

        distanceBetweenAnyTwoNodes obj = new distanceBetweenAnyTwoNodes();
        System.out.println("Distance between 4 and 5: " + obj.findDistance(root, 4, 5));
        System.out.println("Distance between 4 and 3: " + obj.findDistance(root, 4, 3));
    }
}

