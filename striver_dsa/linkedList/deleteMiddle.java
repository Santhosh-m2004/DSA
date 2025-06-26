package linkedList;

public class deleteMiddle {
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

    static  Node deleteMiddleNode(Node head) {
        if(head==null || head.next==null){
        
            return null;
        }
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node prev=head;
        while(prev.next!=slow){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr={10};
        head=new Node(arr[0]);
        Node tail=head;
        for(int i=1;i<arr.length;i++){
            tail.next=new Node(arr[i]);
            tail=tail.next;
        }
        printList(head);
        System.out.println();
        head=deleteMiddleNode(head);
        printList(head);        
    }
}
