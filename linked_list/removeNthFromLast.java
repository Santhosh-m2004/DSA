//Given the head of a linked list, remove the nth node from the end of the list and return its head.
package linked_list;
import java.util.Scanner;
public class removeNthFromLast {
    public static class Node{
        int val;
        Node next;

        Node(int val){
            this.val=val;
            this.next=null;
        }
    }

    public static Node remove(Node head,int n){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(count==n){
            head=head.next;
            return head;
        }
        int idx=count-n;
        Node prev=head;
        int i=1;
        while(i<idx){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
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
        int n=s.nextInt();
        input=input.substring(1,input.length()-1);
        String[] ll=input.split(",".trim());

        Node head=new Node(Integer.parseInt(ll[0].trim()));
        Node cur=head;
        for(int i=1;i<ll.length;i++){
            cur.next=new Node(Integer.parseInt(ll[i].trim()));
            cur=cur.next;
        }
        printList(remove(head,n));
    }
}
