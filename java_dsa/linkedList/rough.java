package linkedList;

public class rough {
    private Node head;

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(String data){
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
    }

    public void addLast(String data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            return;
        }
        Node curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newnode;
    }

    public void printList(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        Node curNode = head;
        while(curNode != null){
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        head = head.next;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node secondLast = head;
        while(secondLast.next.next != null){
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public static void main(String[] args) {
        rough list = new rough();
        list.addFirst("is");
        list.addFirst("a");
        list.addLast("the");
        list.addLast("list");
        list.printList();
    }
}