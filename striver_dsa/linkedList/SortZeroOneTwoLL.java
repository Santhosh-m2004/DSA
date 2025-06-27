package linkedList;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class SortZeroOneTwoLL {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode zeroDummy = new ListNode(0);
        ListNode oneDummy = new ListNode(0);
        ListNode twoDummy = new ListNode(0);

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

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);

        System.out.println("Original list:");
        printList(head);

        head = sortList(head);

        System.out.println("Sorted list:");
        printList(head);
    }
}
