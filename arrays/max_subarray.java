package arrays;
import java.util.*;
// public class max_subarray {
//     public static void main(String[] args) {
//         int[] arr={-2,-3,4,-1,-2,1,5,-3};
//         int n=arr.length;
//         int maxi=Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){
//             int sum=0;
//             for(int j=i;j<n;j++){
                
//                 sum+=arr[j];
//                 maxi=Integer.max(maxi, sum);
//             }
//         }
//         System.out.println(maxi);

//     }
// }

//kadane algorithm
public class max_subarray {
    public static void main(String[] args) {
        int[] arr={-2,-3,-3};
        int n=arr.length;
        int maxi=arr[0];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            maxi=Math.max(maxi,sum);
            if(sum<0){
                sum=0;
            }  
        }
        System.out.println(maxi);

    }
}
