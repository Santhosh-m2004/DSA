package linkedList;

public class intersection{
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node getIntersectionNode(Node headA, Node headB) {
        Node h1 = headA;
        Node h2 = headB;

        while (h1 != h2) {
            if(h1==null){
                h1=headB;
            }else{
                h1=h1.next;
            }

            if(h2==null){
                h2=headA;
            }else{
                h2=h2.next;
            }
        }

        return h1;
    }

    public static void main(String[] args) {
        Node common = new Node(8);
        common.next = new Node(10);

        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = common;

        Node headB = new Node(6);
        headB.next = new Node(7);
        headB.next.next = common;

        Node result = getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection Node: " + result.data);
        } else {
            System.out.println("No Intersection.");
        }
    }
}
