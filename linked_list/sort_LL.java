package linked_list;

// Java Program to sort a linked list of 0s, 1s or 2s

class Node {
    int data;
    Node next;
    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Function to sort a linked list of 0s, 1s and 2s
class sort_LL {
  
    static void sortList(Node head) {
        int[] count={0,0,0};
        Node temp=head;
        while(temp!=null){
            count[temp.data]+=1;
            temp=temp.next;
        }
        
        int index=0;
        temp=head;
        while(temp!=null){
            if(count[index]==0){
                index++;
            }
            else{
                temp.data=index;
                count[index]-=1;
                temp=temp.next;
            }
        }



    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
        // Create a hard-coded linked list:
        // 1 -> 1 -> 2 -> 1 -> 0 -> NULL
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        System.out.print("Linked List before Sorting:");
        printList(head);

        sortList(head);

        System.out.print("Linked List after Sorting:");
        printList(head);
    }
}
