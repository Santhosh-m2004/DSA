package binaryTrees;

import java.util.*;

public class binaryTreeTraversals {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }    

    public static class Binary{
        int idx=-1;
        public  Node BuildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node root=new Node(nodes[idx]);
            root.left=BuildTree(nodes);
            root.right=BuildTree(nodes);
            return root;
        }
    }

    public static void inOrder(Node root){
        if(root==null) return;

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if(root==null) return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrder(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur=q.poll();
            System.out.print(cur.data+" ");
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
        }
    }

    public static int height(Node root){
        if(root==null) return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    public static int diameter(Node root){
        if(root==null) return 0;

        int leftDiameter=diameter(root.left);
        int rightDiamter=diameter(root.right);
        int fullDiameter=height(root.left)+height(root.right)+1;

        return Math.max(fullDiameter,Math.max(rightDiamter, leftDiameter));
    }


    public static void main(String[] args) {
        int[] nums = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary tree=new Binary();
        Node root=tree.BuildTree(nums);
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
        System.out.println(height(root));
        System.out.println(diameter(root));
    }
}

