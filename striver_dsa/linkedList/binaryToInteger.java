package linkedList;

public class binaryToInteger {
    static Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static int getDecimalValue(Node head) {
        int result = 0;
        Node temp = head;
        while (temp != null) {
            result = result * 2 + temp.data;
            temp = temp.next;
        }
        return result;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int[] binaryInput = {1, 0, 1}; // Binary 101 = Decimal 5

        head = new Node(binaryInput[0]);
        Node tail = head;
        for (int i = 1; i < binaryInput.length; i++) {
            tail.next = new Node(binaryInput[i]);
            tail = tail.next;
        }

        System.out.print("Binary Linked List: ");
        printList(head);

        int decimalValue = getDecimalValue(head);
        System.out.println("\nDecimal Value: " + decimalValue);
    }
}
