/*Given an array and a sum k, we need to print the length of the longest subarray that sums to k. */
package Array;
import java.util.*;
public class LongestSubarrayWithGivenSum {
    // public static int res(int[] nums,int k){
    //     int max=0;
    //     for(int i=0;i<nums.length;i++){
    //         int sum=0;
    //         for(int j=i;j<nums.length;j++){
    //             sum+=nums[j];
    //             if(sum==k){
    //                 max=Math.max(max,j-i+1);
    //             }   
    //         }
    //     }
    //     return max;
    // }

       //works only for positive values
    // public static int res(int[] nums,int k){
    //     int i=0;
    //     int j=0;
    //     int len=0;
    //     int maxlen=0;
    //     int sum=0;
    //     while(j<nums.length){
    //         sum+=nums[j];
    //         if(sum==k){
    //             maxlen=Math.max(maxlen,j-i+1);
    //         }
    //         else if(sum<k){
    //             j++;
    //         }else{
    //             i++;
    //         }
    //     }
    //     return maxlen;
    // }

    public static int res(int[] nums,int k){
        int sum=0;
        int maxlen=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k){
                maxlen=i+1;
            }
            int rem=sum-k;

            if(map.containsKey(rem)){
                maxlen=Math.max(maxlen,i-map.get(rem));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxlen;
    }



    public static void main(String[] args) {
        int[] nums={1,2,1,2,3,4,5};
        int k=9;
        System.out.println(res(nums,k));
    }
}
