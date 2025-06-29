package linkedList;
import java.util.*;
public class add1ToLL {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head){
        Node prev=null;
        Node cur=head;
        while(cur!=null){
            Node next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }

    public static Node add(Node l1){
        l1=reverse(l1);
        Node dummy=new Node(0);
        Node cur=dummy;
        int carry=1;
        while(l1!=null || carry!=0){
            int sum=carry;
            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }
            carry=sum/10;
            cur.next=new Node(sum%10);
            cur=cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr={9,9,9};
        Node head=new Node(arr[0]);
        Node tail=head;
        for(int i=1;i<arr.length;i++){
            tail.next=new Node(arr[i]);
            tail=tail.next;
        }
        printList(head);
        head=add(head);
        head=reverse(head);
        printList(head);
    }
}
