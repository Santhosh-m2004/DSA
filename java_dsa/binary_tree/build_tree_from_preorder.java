package binary_tree;
import java.util.*;
public class build_tree_from_preorder {
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
        static int index=-1;

        public static Node buildtree(int nodes[]){
            index++;
            if(nodes[index]==-1){
                return null;
            }
            Node newnode=new Node(nodes[index]);
            newnode.left=buildtree(nodes);
            newnode.right=buildtree(nodes);
            return newnode;
        }
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }

    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data);
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }

        }
        
    }
    public static int countOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftCount=countOfNodes(root.left);
        int rightCount=countOfNodes(root.right);
        return leftCount+rightCount+1;
    }
    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftsum=sumOfNodes(root.left);
        int rightsum=sumOfNodes(root.right);
        return leftsum+rightsum+root.data;
    }
    public static int heightOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftheight=heightOfNodes(root.left);
        int rightheight=heightOfNodes(root.right);
        return (Math.max(leftheight,rightheight))+1;
    }

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int diam1=heightOfNodes(root.left)+heightOfNodes(root.right)+1;
        int diam2=diameter(root.left);
        int diam3=diameter(root.right);
        return Math.max(diam1,Math.max(diam2, diam3));
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        binarytree tree=new binarytree();
        Node root =tree.buildtree(nodes);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(countOfNodes(root));
        System.out.println(sumOfNodes(root));
        System.out.println(heightOfNodes(root));
        System.out.println(diameter(root));

    }
}
