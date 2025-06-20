package trees;
import java.util.*;
public class BinaryTree{

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class binarytree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root==null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void postOrder(Node root) {
        if(root==null){
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root){
        if(root==null){
            return ;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static int height(Node root) {
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    public static int countNodes(Node root) {
        if(root==null){
            return 0;
        }
        int leftCount=countNodes(root.left);
        int rightCount=countNodes(root.right);
        return leftCount+rightCount+1;
    }
    public static int nodesSum(Node root) {
        if(root==null){
            return 0;
        }
        int leftSum=nodesSum(root.left);
        int rightSum=nodesSum(root.right);
        return leftSum+rightSum+root.data;
    }

    public static int diameter(Node root) {
        if(root==null){
            return 0;
        }
        int diam1=diameter(root.left);
        int diam2=diameter(root.right);
        int diam3=height(root.left)+height(root.right)+1;
        return Math.max(diam3,Math.max(diam1,diam1));
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binarytree tree=new binarytree();
        Node root=tree.buildTree(nodes);
        preOrder(root); 
        System.out.println(" ");
        inOrder(root);
        System.out.println(" ");
        postOrder(root);    
        System.out.println(" ");
        levelOrder(root);  
        System.out.println("Height is "+height(root));
        System.out.println("Number of nodes is "+countNodes(root));
        System.out.println("Sum of nodes is "+nodesSum(root));
        System.out.println("Diameter of nodes is "+diameter(root));
    }
}