package linkedList;

public class reverseKGroupLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        if (count < k) return head;

        ListNode newHead = reverse(head, k);
        head.next = reverseKGroup(node, k);
        return newHead;
    }

    private static ListNode reverse(ListNode head, int k) {
        ListNode prev = null, curr = head;
        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                            new ListNode(2,
                            new ListNode(3,
                            new ListNode(4,
                            new ListNode(5)))));

        System.out.print("Original: ");
        printList(head);

        head = reverseKGroup(head, 3);

        System.out.print("Reversed in Groups of 3: ");
        printList(head);
    }
}
