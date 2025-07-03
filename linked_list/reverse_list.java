package linked_list;
import java.util.*;  

public class reverse_list {
    static class ListNode {
    int val;            
    ListNode next;      

    ListNode(int val) {  
        this.val = val;
        this.next = null;
    }
}

    public static ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(",");
            }
            temp = temp.next;
        }
        System.out.println("]");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input=sc.nextLine().trim();

        input=input.substring(1,input.length()-1);

        String ll[]=input.split(",".trim());
        ListNode head=new ListNode(Integer.parseInt(ll[0].trim()));
        ListNode cur=head;
        for(int i=1;i<ll.length;i++){
            cur.next=new ListNode(Integer.parseInt(ll[i].trim()));
            cur=cur.next;
        }

        printList(reverseList(head));
        
    }
}
