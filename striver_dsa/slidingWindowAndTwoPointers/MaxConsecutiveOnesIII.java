package slidingWindowAndTwoPointers;
import java.util.*;
//Brute Force 

// class MaxConsecutiveOnesIII {
//     public  static int longestOnes(int[] nums, int k) {
//         int n=nums.length;
//         int max=Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){
//             int count=0;
//             for(int j=i;j<n;j++){
//                 if(nums[j]==0){
//                     count++;
//                 }
//                 if(count<=k){
//                     max=Math.max(max,j-i+1);
//                 }else{
//                     break;
//                 }
//             }

//         }
//         return max == Integer.MIN_VALUE ? 0 : max;
//     }

//     public static void main(String[] args) {
//         int[] nums={1,1,1,0,0,0,1,1,1,1,0};
//         int k=2;
//         System.out.println(longestOnes(nums, k));
//     }
// }


//optimal
class Solution {
    public static int longestOnes(int[] nums, int k) {
        int left=0;
        int zeroes=0;
        int max=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;

    }
    public static void main(String[] args) {
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums, k));
    }

}