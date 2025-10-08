package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lt148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode low = head;
        ListNode high = mid.next;
        mid.next = null;

        low = sortList(low);
        high = sortList(high);

        return merge(low, high);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode temp = new ListNode(-1);
        ListNode cur = temp;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        while (left != null) {
            cur.next = left;
            cur = cur.next;
            left = left.next;
        }
        while (right != null) {
            cur.next = right;
            cur = cur.next;
            right = right.next;
        }
        return temp.next;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        lt148 obj = new lt148();

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        head = obj.sortList(head);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
