package linked_list;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {  
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Creating a linked list with a cycle
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating a cycle (4 → 2)

        LinkedListCycle solution = new LinkedListCycle();
        System.out.println("Has Cycle: " + solution.hasCycle(head)); // Expected output: true

        // Creating a linked list without a cycle
        ListNode head2 = new ListNode(1);
        ListNode second2 = new ListNode(2);
        ListNode third2 = new ListNode(3);
        ListNode fourth2 = new ListNode(4);

        head2.next = second2;
        second2.next = third2;
        third2.next = fourth2;
        fourth2.next = null; // No cycle

        System.out.println("Has Cycle: " + solution.hasCycle(head2)); // Expected output: false
    }
}