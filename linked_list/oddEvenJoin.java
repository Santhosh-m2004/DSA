package linked_list;
import java.util.*;
public class oddEvenJoin {
    public static class Node{
        int val;
        Node next;

        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static Node oddEven(Node head){
        Node odd=head;
        Node even=head.next;
        Node evenHead=even;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }

    public static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null){
                System.out.print(",");
            }
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String input=s.nextLine().trim();
        input=input.substring(1,input.length()-1);
        String[] ll=input.split(",".trim());

        Node head=new Node(Integer.parseInt(ll[0].trim()));
        Node cur=head;
        for(int i=1;i<ll.length;i++){
            cur.next=new Node(Integer.parseInt(ll[i].trim()));
            cur=cur.next;
        }
        printList(oddEven(head));
    }
}
