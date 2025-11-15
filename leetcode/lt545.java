package leetcode;

/**
 * -------------------------------------------------------------
 *  LeetCode 545: Boundary of Binary Tree
 * -------------------------------------------------------------
 * Problem Description:
 * You are given the root of a binary tree. You must return 
 * the boundary of the tree in anti-clockwise direction starting 
 * from the root.
 * 
 * Boundary consists of:
 * 1. Root node
 * 2. Left boundary (excluding leaves)
 * 3. All leaf nodes (left to right)
 * 4. Right boundary (excluding leaves, added in reverse order)
 *
 * Corner Cases:
 * - If root is a leaf, return only [root.val].
 * - No node should appear twice.
 * - Left/right boundary should skip leaf nodes.
 *
 * You will implement the actual logic inside:
 *      boundaryOfBinaryTree(TreeNode root)
 *
 * -------------------------------------------------------------
 * Use this skeleton in VS Code.
 * -------------------------------------------------------------
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class lt545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> lst=new ArrayList<>();
        if(!isLeaf(root))
            lst.add(root.val);
        addLeft(root.left,lst);
        addLeaves(root,lst);
        addRight(root.right,lst);
        return lst;
    }
    public static boolean isLeaf(TreeNode root){
        return root!=null && root.left==null && root.right== null;
    }


    public static void addLeft(TreeNode root,ArrayList<Integer> lst){
        TreeNode cur=root;
        while(cur!=null){
            if(!isLeaf(cur)){
            lst.add(cur.val);
            }
            if(cur.left!=null){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
    }

    public static void addRight(TreeNode root,ArrayList<Integer> lst){
        TreeNode cur=root;
        while(cur!=null){
            if(!isLeaf(cur)){
            lst.add(cur.val);
            }
            if(cur.right!=null){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
    }

    public static void addLeaves(TreeNode root,ArrayList<Integer> lst){
        if(root==null){
            return;
        }
        if (isLeaf(root)){
            lst.add(root.val);
        }else{
            addLeaves(root.left, lst);
            addLeaves(root.right, lst);
        }
    }


    public static TreeNode buildSampleTree() {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
               / \
              7   8
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        return root;
    }

    public static void main(String[] args) {

        lt545 obj = new lt545();

        TreeNode root = buildSampleTree();

        List<Integer> result = obj.boundaryOfBinaryTree(root);

        System.out.println("Boundary Traversal: " + result);
    }
}
