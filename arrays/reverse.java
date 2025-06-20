package arrays;
import java.util.*;
// public class reverse {
//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         int[] arr={1,2,3,4,5};
//         int[] newarr=new int[5];
//         for(int i=0;i<5;i++){
//             newarr[i]=arr[arr.length-i-1];
//         }

//         for(int i=0;i<5;i++){
//             System.out.println(newarr[i]);
//         }

//     }
// }


public class reverse {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int[] arr={1,2,3,4,5};
       
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }

        for(int i=0;i<5;i++){
            System.out.println(arr[i]);
        }

    }
}
