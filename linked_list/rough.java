package linked_list;
import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class rough {
    public static void printList(Node head) {
        Node temp = head;
        int length=0;
        while (temp != null) {
            length++;
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println(length);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();
        System.out.print("Enter values of nodes: ");
        Node head = new Node(sc.nextInt());
        Node tail = head;

        for (int i = 1; i < n; i++) {
            int value = sc.nextInt();
            tail.next = new Node(value);
            tail = tail.next;
        }

        System.out.println("Original List:");
        printList(head);

    }

}
