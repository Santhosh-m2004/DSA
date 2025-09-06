package binaryTrees;

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class boundaryTraversal {

    public static ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> lst = new ArrayList<>();
        if (node == null) return lst;

        if (!isLeaf(node)) lst.add(node.data);

        addLeft(node, lst);
        addLeafs(node, lst);
        addRight(node, lst);

        return lst;
    }

    public static void addLeft(Node root, ArrayList<Integer> lst) {
        Node cur = root.left;

        while (cur != null) {
            if (!isLeaf(cur)) lst.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    public static void addRight(Node root, ArrayList<Integer> lst) {
        Node cur = root.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (cur != null) {
            if (!isLeaf(cur)) temp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }

        // Reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            lst.add(temp.get(i));
        }
    }

    public static void addLeafs(Node root, ArrayList<Integer> lst) {
        if (isLeaf(root)) {
            lst.add(root.data);
            return;
        }
        if (root.left != null) addLeafs(root.left, lst);
        if (root.right != null) addLeafs(root.right, lst);
    }

    public static boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }

    public static void main(String[] args) {
        // Static input tree:
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        ArrayList<Integer> result = boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + result);
    }
}

