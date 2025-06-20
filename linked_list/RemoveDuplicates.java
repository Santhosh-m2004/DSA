package linked_list;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class RemoveDuplicates {
    // Function to remove duplicates (Implementation not included)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr1=head;
        while(curr1!=null){
            ListNode curr2=curr1;
            while(curr2.next!=null){
                if(curr2.next.val==curr1.val){
                    curr2.next=curr2.next.next;
                }else{
                    curr2=curr2.next;
                }
            }

            curr1=curr1.next;
        }
        return head;
    }

    // Utility function to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Utility function to create a linked list from an array
    public ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();
        
        // Sample input: 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
        int[] inputValues = {12, 11, 12, 21, 41, 43, 21};
        ListNode head = obj.createList(inputValues);
        
        System.out.println("Original List:");
        obj.printList(head);

        // Calling the function (implementation needs to be added)
        head = obj.deleteDuplicates(head);
        
        System.out.println("After Removing Duplicates:");
        obj.printList(head);
    }
}

