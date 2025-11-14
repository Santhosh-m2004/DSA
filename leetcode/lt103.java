package leetcode;

import java.util.*;

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

public class lt103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> lst = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if (!reverse) {
                    TreeNode cur = q.pollFirst();
                    lst.add(cur.val);
                    if (cur.left != null) q.addLast(cur.left);
                    if (cur.right != null) q.addLast(cur.right);
                } else {
                    TreeNode cur = q.pollLast();
                    lst.add(cur.val);
                    if (cur.right != null) q.addFirst(cur.right);
                    if (cur.left != null) q.addFirst(cur.left);
                }
            }
            res.add(lst);
            reverse = !reverse;
        }
        return res;
    }

    public static void main(String[] args) {
        lt103 obj = new lt103();

        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );

        System.out.println(obj.zigzagLevelOrder(root));
    }
}

