package DP;
import java.util.*;
// Given an array nums representing money in each house, return the maximum amount you can rob without robbing two adjacent houses.
public class houseRobber1 {

    static int res(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1){
                pick+=dp[i-2];
            }
            int nonpick=dp[i-1];
            dp[i]=Math.max(pick,nonpick);
        }
        return dp[n-1];

    }
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(res(nums));
    }
}
