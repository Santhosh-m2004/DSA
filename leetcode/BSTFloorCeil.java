package leetcode;
import java.util.*;
/*
Problem: Floor and Ceil in a BST

Given the root of a Binary Search Tree and a key value,
find:
- Floor  → greatest value <= key
- Ceil   → smallest value >= key
If floor or ceil doesn't exist, return -1.

Input Example:
BST = [8, 4, 12, 2, 6, 10, 14], key = 11
Output: [10, 12]

Another:
key = 15 → [14, -1]
key = 1  → [-1, 2]
*/

class BSTFloorCeil {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public int[] floorCeilBST(TreeNode root, int key) {
        int floor = -1, ceil = -1;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val == key) {
                floor = key;
                ceil = key;
                break;
            } else if (cur.val < key) {
                floor = cur.val;
                cur = cur.right;
            } else {
                ceil = cur.val;
                cur = cur.left;
            }
        }
        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        BSTFloorCeil s = new BSTFloorCeil();

        // BST: [8,4,12,2,6,10,14]
        TreeNode root = s.new TreeNode(8);
        root.left = s.new TreeNode(4);
        root.right = s.new TreeNode(12);
        root.left.left = s.new TreeNode(2);
        root.left.right = s.new TreeNode(6);
        root.right.left = s.new TreeNode(10);
        root.right.right = s.new TreeNode(14);

        int key = 11;
        int[] ans = s.floorCeilBST(root, key);

        System.out.println("Floor = " + ans[0] + ", Ceil = " + ans[1]);
    }
}
