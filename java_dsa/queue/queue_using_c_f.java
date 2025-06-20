package queue;

//queue using Java Collection Framework
import java.util.*;


public class queue_using_c_f {
   public static void main(String args[]) {
       //Queue<Integer> q = new LinkedList();
       Queue<Integer> q = new ArrayDeque();
       //Queue is a interface not a class so we can't create a object for  interface 
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);


       while(!q.isEmpty()) {
           System.out.println(q.peek());
           q.remove();
       }
   }
}
