package linked_list; // Ensure this package declaration is present in both files
import java.util.*;

/**
 * Definition for singly-linked list.
 */
class ListNode1 {  
    int val;  // The value stored in the node
    ListNode1 next;  // Pointer to the next node in the list

    // Default constructor (no value)
    ListNode1() {}

    // Constructor with a single value (creates a node with the given value)
    ListNode1(int val) { this.val = val; }

    // Constructor with a value and next node reference
    ListNode1(int val, ListNode1 next) { 
        this.val = val; 
        this.next = next; 
    }
}

/**
 * MergeSortedList class to merge two sorted linked lists.
 */
public class MergeSortedList {
    public static ListNode1 mergeTwoLists(ListNode1 list1, ListNode1 list2) {
        ListNode1 temp = new ListNode1(-1);  
        ListNode1 current = temp;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {  
                current.next = list1;  
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;
        
        return temp.next;
    }

    public static void printList(ListNode1 head) {
        ListNode1 temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating two sorted linked lists for testing
        ListNode1 list1 = new ListNode1(1, new ListNode1(3, new ListNode1(5)));
        ListNode1 list2 = new ListNode1(2, new ListNode1(4, new ListNode1(6)));

        // Merging the lists
        ListNode1 mergedList = mergeTwoLists(list1, list2);

        // Printing the merged list
        System.out.print("Merged List: ");
        printList(mergedList);
    }                
}
