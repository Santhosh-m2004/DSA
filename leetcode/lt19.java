package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lt19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int idx = count - n;
        if (idx == 0) {
            return head.next;
        }
        ListNode cur = head;
        for (int i = 0; i < idx - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        lt19 solution = new lt19();
        ListNode result = solution.removeNthFromEnd(n1, 2);

        printList(result); // Expected: 1 -> 2 -> 3 -> 5 -> null
    }
}
