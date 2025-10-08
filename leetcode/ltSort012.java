package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class ltSort012 {
    public ListNode sort012(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy = new ListNode(-1);
        ListNode twoDummy = new ListNode(-1);

        ListNode zero = zeroDummy, one = oneDummy, two = twoDummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.val == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null; 

        return zeroDummy.next;
    }

    public static void main(String[] args) {
        ltSort012 obj = new ltSort012();

        // Example: 1 -> 2 -> 0 -> 1 -> 2 -> 0
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);

        head = obj.sort012(head);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

