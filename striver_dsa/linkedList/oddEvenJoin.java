package linkedList;

class oddEvenJoin {

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
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) return head;
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
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60};
        head=new Node(arr[0]);
        Node tail=head;
        for(int i=1;i<arr.length;i++){
            tail.next=new Node(arr[i]);
            tail=tail.next;
        }
        oddEvenList(head);
        printList(head);
        
    }
}
