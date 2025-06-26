package linkedList;


public class removeNthNodeFromLast {

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
    public static Node removeNthFromEnd(Node head, int n) {
        int count=0;
        Node cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        if (n == count) {
            return head.next;
        }

        int idx=count-n;
        int i=1;
        Node prev=head;
        while(i<idx){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return head;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60};
        head=new Node(arr[0]);
        Node tail=head;
        for(int i=1;i<arr.length;i++){
            tail.next=new Node(arr[i]);
            tail=tail.next;
        }
        int n=2;
        removeNthFromEnd(head,n);
        printList(head);
        
    }
}
