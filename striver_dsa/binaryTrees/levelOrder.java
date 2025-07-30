package binaryTrees;
import java.util.*;
public class levelOrder {
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

    public static class binary{
        static int idx=-1;
        public static Node buildTree(int[] nums){
            idx++;
            if(nums[idx]==-1){
                return null;
            }
            Node newNode=new Node(nums[idx]);
            newNode.left=buildTree(nums);
            newNode.right=buildTree(nums);
            return newNode;
        }
    }
    public static List<List<Integer>> levelO(Node root){
        List<List<Integer>> res=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelsize=q.size();
            List<Integer> lst=new ArrayList<>();
            for(int i=0;i<levelsize;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right !=null){
                    q.add(q.peek().right);
                }
                lst.add(q.poll().data);
            }
            res.add(new ArrayList<>(lst));
        }
        return res;

    }
    public static void main(String[] args) {
        int[] nodes = {3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1};
        binary t=new binary();
        Node root=t.buildTree(nodes);
        System.out.println(levelO(root));
    }
}
