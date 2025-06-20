package linked_list;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class sort_list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input like: [4,2,1,3]
        String input = sc.nextLine().trim();

        // Remove brackets and spaces
        input = input.replace("[", "").replace("]", "").replace(" ", "");
        if (input.isEmpty()) return;

        // Split string into numbers
        String[] parts = input.split(",");
        int n = parts.length;

        // Build linked list
        ListNode head = new ListNode(Integer.parseInt(parts[0]));
        ListNode curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(Integer.parseInt(parts[i]));
            curr = curr.next;
        }

        // Sort the list
        head = sortList(head);

        // Print sorted list
        curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" ");
            curr = curr.next;
        }
    }

    static ListNode sortList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;

        // Extract values
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        // Sort values
        Collections.sort(values);

        // Assign back sorted values
        current = head;
        for (int val : values) {
            current.val = val;
            current = current.next;
        }

        return head;
    }
}
