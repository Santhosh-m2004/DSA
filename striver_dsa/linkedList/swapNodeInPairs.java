package linkedList;

public class swapNodeInPairs {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        second.next = swapPairs(second.next);
        return head;
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
                            new ListNode(4))));

        System.out.print("Original: ");
        printList(head);

        head = swapPairs(head);

        System.out.print("Swapped:  ");
        printList(head);
    }
}
