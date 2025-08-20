package binaryTrees;

public class binaryTree {
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

    public static void main(String[] args) {
        int[] nums = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary tree=new Binary();
        Node root=tree.BuildTree(nums);
        System.out.println(root.data);
    }
}
