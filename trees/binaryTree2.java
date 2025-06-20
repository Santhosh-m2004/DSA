package trees;
import java.util.*;
public class binaryTree2 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static class binarytree{
        static int idx=-1;
        static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode =new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
    }
    public static void preOrder(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binarytree tree=new binarytree();
        Node root=tree.buildTree(nodes);
        preOrder(root);


    }
}
