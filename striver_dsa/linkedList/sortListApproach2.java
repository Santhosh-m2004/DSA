package linkedList;
import java.util.*;
class sortListApproach2 {
    static Node head;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    public static Node sortList(Node head) {
        ArrayList<Integer> a=new ArrayList<>();
        Node t=head,temp=head;
        while(t!=null){
            a.add(t.data);
            t=t.next;
        }
        Collections.sort(a);
        for(int i=0;i<a.size();i++){
            temp.data=a.get(i);
            temp=temp.next;
        }
        return head;
    }

    

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {56,25,84,2,45,456,65};
        head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }

        System.out.println("Original List:");
        printList(head);
        head=sortList(head);
        System.out.println("Reversed List:");
        printList(head);
    }
}


