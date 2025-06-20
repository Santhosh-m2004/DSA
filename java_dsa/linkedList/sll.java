package linkedList;
class LL{
    private Node head;
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;

        }
    }

    public void addFirst(String data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }

    public void addLast(String data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }

        Node curNode=head;
        while(curNode.next!=null){
            curNode=curNode.next;
        }
        curNode.next=newnode;
    }

    public void printList(){
        if(head==null){
            System.out.print("Empty");
            return;
        }
        Node curNode=head;
        while(curNode!=null){
            System.out.print(curNode.data+" -> ");
            curNode=curNode.next;
        }
        System.out.println("NULL");
    }

    public void deletefirst(){
        if(head==null){
            System.out.println("empty");
            return;
        }
        head=head.next;
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("empty");
            return;
        }

        if(head.next==null){
            head=null;
            return;
        }
        
        Node secondlast=head;
        Node lastnode=head.next;
        while(lastnode.next!=null){
            secondlast=secondlast.next;
            lastnode=lastnode.next;
        }
        secondlast.next=null;
    }

    public void reverseIterative(){
        if(head==null || head.next==null){
            return;
        }

        Node prevNode=head;
        Node curNode=head.next;
        while(curNode!=null){
            Node nextNode=curNode.next;
            curNode.next=prevNode;

            //update
            prevNode=curNode;
            curNode=nextNode;
        }
        head.next=null;
        head=prevNode;
    }

    public Node reverseRecursive(Node head){
        if(head==null || head.next==null){
            return head;
        }

        Node newHead=reverseRecursive(head.next);
        head.next.next=head;
        head.next=null;

        return newHead;
    }

    public static void main(String[] args) {
        LL list=new LL();
        list.addFirst("is");
        list.addFirst("a");
        list.addLast("the");
        list.addLast("list");
        list.printList();
        list.deletefirst();
        list.deleteLast();
        list.printList();
        list.reverseIterative();
        list.printList();
        list.head=list.reverseRecursive(list.head);
        list.printList();
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        
        int size=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        if(n==size){
            return head.next;
        }
        int indexToSearch=size-n;
        ListNode prev=head;
        int i=1;
        while(i<indexToSearch){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return head;
    }
}*/