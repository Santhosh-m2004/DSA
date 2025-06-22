package linkedList;

import java.util.*;

public class basicsLL {
    static Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        } 
    }

    static void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next=head;
        head = newNode;
    }

    static void addLast(int data){
        Node newNode =new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    static void deleteFirst(){
        if(head==null){
            return;
        }
        head=head.next;
    }

    static void deleteLast(){
        if(head==null){
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node secondlast=head;
        Node lastnode=head.next;
        while(lastnode.next!=null){
            secondlast=secondlast.next;
            lastnode=lastnode.next;
        }
        secondlast.next=null;
    }

    static void printList(Node head){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
        //Input-based Logic
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int n = sc.nextInt();
        System.out.println("Enter the value of Nodes");
        Node head = new Node(sc.nextInt());
        Node tail = head;
        for(int i = 1; i < n; i++){
            int value = sc.nextInt();
            tail.next = new Node(value);
            tail = tail.next;
        }
        System.out.println("Original List");
        printList(head);
        */

        // Static Data
        int[] staticData = {10, 20, 30, 40, 50};
        head = new Node(staticData[0]);
        Node tail = head;
        for(int i = 1; i < staticData.length; i++){
            tail.next = new Node(staticData[i]);
            tail = tail.next;
        }
        System.out.println("Original List:");
        printList(head);
        addFirst(60);
        printList(head);
        addLast(70);
        printList(head);
        deleteFirst();
        printList(head);
        deleteLast();
        printList(head);
    }
}
