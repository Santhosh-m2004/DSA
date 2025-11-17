package leetcode;

/**
 * Root to Node Path in Binary Tree
 * Goal: Print the path from root to a given target value.
 *
 * Example:
 * Tree:
 *         1
 *       /   \
 *      2     3
 *     / \
 *    4   5
 *
 * Target = 5
 * Output: [1, 2, 5]
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public  class RootToNodePath {

    public static boolean recursion(TreeNode root, int target, List<Integer> path) {
        if(root==null){
            return false;
        }
        path.add(root.val);
        if(root.val==target){
            return true;
        }

        if(recursion(root.left, target, path) || recursion(root.right, target, path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static ArrayList<Integer> pathSum(TreeNode root,int target){
        ArrayList<Integer> lst=new ArrayList<>();
        recursion(root,target,lst);
        return lst;
    }

    public static void main(String[] args) {

        // Tree:
        //         1
        //       /   \
        //      2     3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int target = 5;
        System.out.println(pathSum(root, target));
        
    }
}
