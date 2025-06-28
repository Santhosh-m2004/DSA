

package linkedList;

public class add2LL {
    static Node head;
    public static class Node{
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
    }

    static  Node add(Node l1,Node l2) {
        Node dummy=new Node(0);
        Node cur=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int sum=carry;
            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2=l2.next;
            }
            carry=sum/10;
            cur.next=new Node(sum%10);
            cur=cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        // Adding the two lists
        Node result = add(l1, l2);

        System.out.print("Result: ");
        printList(result);
             
    }
}
