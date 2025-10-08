package leetcode;
public class lt2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode cur = temp;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }
        return temp.next;
    }

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        lt2 obj = new lt2();

        // Example 1: 342 + 465 = 807
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = obj.addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        printList(result); // 7 -> 0 -> 8

        // Example 2: 0 + 0 = 0
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        result = obj.addTwoNumbers(l3, l4);
        System.out.print("Result: ");
        printList(result); // 0

        // Example 3: 9999 + 1 = 10000
        ListNode l5 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l6 = new ListNode(1);
        result = obj.addTwoNumbers(l5, l6);
        System.out.print("Result: ");
        printList(result); // 0 -> 0 -> 0 -> 0 -> 1
    }
}
