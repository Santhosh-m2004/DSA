package linked_list;
import java.util.*;  



public class rotateLLByk {
    static class ListNode {
    int val;            
    ListNode next;      

    ListNode(int val) {  
        this.val = val;
        this.next = null;
    }
}
    public static ListNode rotate(ListNode head,int k){
        if(head==null || head.next==null ||k==0){
            return head;
        }
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        k=k%count;
        for(int i=1;i<=k;i++){
           head=reverse(head);
           ListNode secondPart=reverse(head.next); 
           head.next=secondPart;
        }
        return head;
    }

    public static ListNode reverse(ListNode head){
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
        int[] arr={1,2,3,4,5};
        int k=2;
        ListNode head=new ListNode(arr[0]);
        ListNode tail=head;
        for(int i=1;i<arr.length;i++){
            tail.next=new ListNode(arr[i]);
            tail=tail.next;
        }
        System.out.print("Original :");
        printList(head);
        head=rotate(head, k);
        printList(head);     
    }
}
