package linked_list;

import java.util.Scanner;

public class palindrome {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        ListNode cur=slow;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;  
        }
        ListNode start=head;
        ListNode middle=prev;
        while(middle!=null){
            if(middle.val!=start.val){
                return false;
            }
            middle=middle.next;
            start=start.next;
        }
        return true;
    }
 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine().trim();
        input=input.substring(1,input.length()-1);
        String[] values=input.split(",".trim());
        ListNode head=new ListNode(Integer.parseInt(values[0].trim()));
        ListNode cur=head;
        for(int i=1;i<values.length;i++){
            cur.next=new ListNode(Integer.parseInt(values[i].trim()));
            cur=cur.next;
        }
        System.out.println(isPalindrome(head));
    }
}
