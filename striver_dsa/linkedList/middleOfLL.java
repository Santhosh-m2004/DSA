package linkedList;

public class middleOfLL {
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

    static  Node middleNode(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60};
        head=new Node(arr[0]);
        Node tail=head;
        for(int i=1;i<arr.length;i++){
            tail.next=new Node(arr[i]);
            tail=tail.next;
        }
        System.out.println(middleNode(head).data);
        
    }
}
