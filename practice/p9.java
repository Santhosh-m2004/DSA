package practice;
import java.util.*;

public class p9 {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node add(Node n1, Node n2) {
        Node temp = new Node(-1);
        Node cur = temp;
        int carry = 0;
        while (n1 != null || n2 != null || carry != 0) {
            int sum = carry;
            if (n1 != null) {
                sum += n1.data;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.data;
                n2 = n2.next;
            }
            carry = sum / 10;
            cur.next = new Node(sum % 10);
            cur = cur.next;
        }
        return temp.next;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 9, 9};
        int[] arr2 = {1, 1, 1};

        Node node1 = new Node(arr1[0]);
        Node n1 = node1;
        for (int i = 1; i < arr1.length; i++) {
            n1.next = new Node(arr1[i]);
            n1 = n1.next;
        }

        Node node2 = new Node(arr2[0]);
        Node n2 = node2;
        for (int i = 1; i < arr2.length; i++) {
            n2.next = new Node(arr2[i]);
            n2 = n2.next;
        }

        Node n3 = add(node1, node2);
        n3 = reverse(n3);  
        printNode(n3);
    }
}
