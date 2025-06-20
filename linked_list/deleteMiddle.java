/*You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, 
where ⌊x⌋ denotes the largest integer less than or equal to x.
For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively. */

package linked_list;
import java.util.*;
public class deleteMiddle {
    public static class Node{
        int val;
        Node next;

        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static Node remove(Node head){
         if (head == null || head.next == null) {
            return null; // List with 0 or 1 node
        }
        Node slow=head;
        Node fast=head;
        Node prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
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
        printList(remove(head));
    }
}
