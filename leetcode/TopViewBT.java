package leetcode;

/**
 * -------------------------------------------------------------
 *  Top View of Binary Tree
 * -------------------------------------------------------------
 * Problem:
 * Print the top view of a binary tree. Top view means the nodes
 * visible when the tree is viewed from the top.
 *
 * Approach (You will implement inside topView()):
 * - Use Queue for BFS
 * - Use HashMap to store first node at each horizontal distance (HD)
 * - Left child = HD - 1
 * - Right child = HD + 1
 * - Traverse from minHD → maxHD
 *
 * -------------------------------------------------------------
 */

import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class TopViewBT {

    static class pair{
        TreeNode cur;
        int line;
        pair(TreeNode cur,int line){
            this.cur=cur;
            this.line=line;
        }
    }

    public List<Integer> topView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> lst=new ArrayList<>();
        Queue<pair> q=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();

        q.add(new pair(root, 0));

        while(!q.isEmpty()){
            pair temp=q.poll();
            TreeNode v=temp.cur;
            int l=temp.line;

            if(map.get(l)==null){
                map.put(l,v.val);
            }
            if(v.left!=null){
                q.add(new pair(v.left, l-1));
            }
            if(v.right!=null){
                q.add(new pair(v.right, l+1));
            }
        }

        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            lst.add(entry.getValue());
        }
        //lst.addAll(map.getValues);
        
        return lst;
    }


    public static TreeNode buildSampleTree() {
        /*
                 1
               /   \
              2     3
               \   / \
                4 5   6
                     /
                    7

            Top View → 2, 1, 3, 6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.right.left = new TreeNode(7);

        return root;
    }


    public static void main(String[] args) {

        TopViewBT obj = new TopViewBT();

        TreeNode root = buildSampleTree();

        List<Integer> result = obj.topView(root);

        System.out.println("Top View: " + result);
    }
}

