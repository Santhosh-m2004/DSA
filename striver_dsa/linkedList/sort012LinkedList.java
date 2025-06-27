package linkedList;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}

public class sort012LinkedList {

    public static Node sortList(Node head) {
        int zero = 0, one = 0, two = 0;
        Node temp = head;

        while (temp != null) {
            if (temp.data == 0) zero++;
            else if (temp.data == 1) one++;
            else two++;
            temp = temp.next;
        }

        // Overwrite values
        temp = head;
        while (zero-- > 0) {
            temp.data = 0;
            temp = temp.next;
        }
        while (one-- > 0) {
            temp.data = 1;
            temp = temp.next;
        }
        while (two-- > 0) {
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);

        System.out.println("Original list:");
        printList(head);

        head = sortList(head);

        System.out.println("Sorted list:");
        printList(head);
    }
}
