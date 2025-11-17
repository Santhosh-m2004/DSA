package leetcode;

public class lt450 {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode deleteNode(TreeNode root, int val) {
        if(root==null){
            return null;
        }

        if(val<root.val){
            root.left=deleteNode(root.left, val);
        }else if(val>root.val){
            root.right=deleteNode(root.right, val);
        }else{
            if(root.right==null && root.left==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                TreeNode successor=minValue(root.right);
                root.val=successor.val;
                root.right=deleteNode(root.right, successor.val);
            }
        }
        return root;
    }

    public static TreeNode minValue(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = null;
        int[] arr = {8, 5, 10, 3, 6, 9, 12};

        for (int x : arr)
            root = insert(root, x);

        System.out.print("Original BST: ");
        inorder(root);

        int key = 5;
        root = deleteNode(root, key);

        System.out.print("\nAfter deleting " + key + ": ");
        inorder(root);
    }
}

