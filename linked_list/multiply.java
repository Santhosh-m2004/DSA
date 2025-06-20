package linked_list;

// Java program to Multiply two numbers
// represented as linked lists

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class multiply{
  
    // Multiply contents of two linked lists
    static long multiplyTwoLists(Node first, Node second) {
        long mod=1000000007;
        long num1=0,num2=0;
        while(first!=null || second!=null){
            if(first!=null){
                num1=(num1*10+first.data)%mod;
                first=first.next;

            }
            if(second!=null){
                num2=(num2*10+second.data)%mod;
                second=second.next;
            }
        }

        return (num1*num2)%mod;
    }
    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String args[]) {
      
        // create first list 9->4->6
        Node head1 = new Node(9);
        head1.next = new Node(4);
        head1.next.next = new Node(6);

        // create second list 8->4
        Node head2 = new Node(8);
        head2.next = new Node(4);
        System.out.println(multiplyTwoLists(head1, head2));
    }
}

