package leetcode;
/*You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit.
 Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807. */
public class l2 {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static void printList(Node head){
        if(head==null){
            return ;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static Node add(Node l1,Node l2){
        int carry=0;
        Node temp=new Node(-1);
        Node cur=temp;
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
        return temp.next;
    }

    public static void main(String[] args) {
        int[] l1 = {9,9,9,9,9,9,9};
        int[] l2 = {9,9,9,9};

        Node n1=new Node(l1[0]);
        Node node1=n1;
        for(int i=1;i<l1.length;i++){
            node1.next=new Node(l1[i]);
            node1=node1.next;
        }

        Node n2=new Node(l2[0]);
        Node node2=n2;
        for(int i=1;i<l2.length;i++){
            node2.next=new Node(l2[i]);
            node2=node2.next;
        }
        printList(add(n1, n2));


    }

}
