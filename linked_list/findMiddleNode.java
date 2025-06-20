package linked_list;

import java.util.*;

public class findMiddleNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val)
        { 
            this.val = val;
            this.next = null; 
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { /* for finding first middle ele && fast.next.next!=null*/
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();  // e.g., "[1,2,3,4,5]"

        if (input.length() <= 2) {
            System.out.println("Empty list");
            return;
        }

        // Remove [ and ], then split by ,
        input = input.substring(1, input.length() - 1);  // "1,2,3,4,5"
        String[] values = input.split(",");

        // Build linked list
        ListNode head = new ListNode(Integer.parseInt(values[0].trim()));
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i].trim()));
            current = current.next;
        }

        // Find and print middle node
        ListNode mid = middleNode(head);
        System.out.println(mid.val);
    }
}

