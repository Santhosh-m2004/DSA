package linkedList;
class rough{
    private Node head;
    int count=0;
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
            count++;
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

    public void delete_n(){
        
    }

    public static void main(String[] args) {
        rough list=new rough();
        list.addFirst("is");
        list.addFirst("a");
        list.addLast("the");
        list.addLast("list");
        list.printList();
        
    }
}