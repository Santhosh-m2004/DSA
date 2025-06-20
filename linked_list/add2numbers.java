package linked_list;
import java.util.*;

public class add2numbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
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

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        return dummy.next;
    }

    public static ListNode buildList(String input) {
        input = input.replace("[", "").replace("]", "").replace(" ", "");
        if (input.isEmpty()) return null;

        String[] parts = input.split(",");
        ListNode head = new ListNode(Integer.parseInt(parts[0]));
        ListNode current = head;

        for (int i = 1; i < parts.length; i++) {
            current.next = new ListNode(Integer.parseInt(parts[i]));
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        ListNode l1 = buildList(line1);
        ListNode l2 = buildList(line2);

        ListNode result = addTwoNumbers(l1, l2);
        printList(result);
    }
}
