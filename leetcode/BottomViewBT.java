package leetcode;

/**
 * -------------------------------------------------------------
 *  Bottom View of Binary Tree
 * -------------------------------------------------------------
 * Problem:
 * Print the bottom view of a binary tree. Bottom view means the 
 * nodes visible when the tree is viewed from the bottom.
 *
 * Approach (You will implement inside bottomView()):
 * - Use Queue for BFS
 * - Use Map<HD, Node> to store node at each horizontal distance
 * - Update map always because bottom-most should overwrite top
 * - Left child = HD - 1
 * - Right child = HD + 1
 * - Traverse Map in sorted HD order
 *
 * -------------------------------------------------------------
 */

import java.util.*;

import leetcode.TopViewBT.pair;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class BottomViewBT {

    // Pair class to store node + horizontal distance
    static class pair{
        TreeNode cur;
        int line;
        pair(TreeNode cur,int line){
            this.cur=cur;
            this.line=line;
        }
    }


    // ---------------------------------------------------------
    // TODO: Implement Bottom View Logic Here
    // ---------------------------------------------------------
    public List<Integer> bottomView(TreeNode root) {

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

            map.put(l,v.val);

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


    // Sample tree for testing
    public static TreeNode buildSampleTree() {
        /*
                 20
                /  \
              8     22
            /   \     \
           5    3      25
              /   \
             10   14

            Bottom View → 5, 10, 3, 14, 25
        */

        TreeNode root = new TreeNode(20);

        root.left = new TreeNode(8);
        root.right = new TreeNode(22);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(25);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        return root;
    }


    // Main method for VS Code testing
    public static void main(String[] args) {

        BottomViewBT obj = new BottomViewBT();

        TreeNode root = buildSampleTree();

        List<Integer> result = obj.bottomView(root);

        System.out.println("Bottom View: " + result);
    }
}
