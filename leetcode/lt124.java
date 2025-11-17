package leetcode;

/**
 * -------------------------------------------------------------
 *  LeetCode 124: Binary Tree Maximum Path Sum
 * -------------------------------------------------------------
 * Problem:
 * A path in a binary tree is a sequence of nodes where each pair
 * of adjacent nodes is connected by an edge. A path does not need
 * to start at the root or end at a leaf.
 *
 * Goal:
 * Find the maximum path sum of ANY path in the tree.
 *
 * Approach:
 * - Use DFS (helper function)
 * - For each node, compute:
 *      1. max sum from left branch (ignore if negative)
 *      2. max sum from right branch (ignore if negative)
 *      3. best path passing THROUGH current node:
 *         left + node + right
 * - Update global answer for every node
 * - Return (node + max(left, right)) for recursion beacuse i only need to choose a single path either from left or right
 *
 * -------------------------------------------------------------
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class lt124 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        ans = Math.max(ans, node.val + left + right);

        return node.val + Math.max(left, right);
    }

    public static TreeNode buildSampleTree() {
        /*
                 -10
                 /  \
                9   20
                   /  \
                  15   7

            Maximum Path Sum = 42
            Path = 15 -> 20 -> 7
        */

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return root;
    }


    public static void main(String[] args) {

        lt124 obj = new lt124();

        TreeNode root = buildSampleTree();

        int result = obj.maxPathSum(root);

        System.out.println("Maximum Path Sum: " + result);
    }
}

