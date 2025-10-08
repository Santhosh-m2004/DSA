package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class lt160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;

        while (h1 != h2) {
            h1 = (h1 == null) ? headB : h1.next;
            h2 = (h2 == null) ? headA : h2.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        // Create intersection example:
        // A: 4 -> 1 \
        //             8 -> 4 -> 5
        // B:     5 -> 0 -> 1 /

        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        lt160 obj = new lt160();
        ListNode ans = obj.getIntersectionNode(headA, headB);

        if (ans != null) {
            System.out.println("Intersection Node: " + ans.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
