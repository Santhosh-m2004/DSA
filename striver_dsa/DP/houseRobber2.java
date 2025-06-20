package DP;
import java.util.*;
public class houseRobber2 {
    static int range(int[] nums,int[] dp,int start,int end){
        int n=end-start+1;
        if (n == 0) return 0;
        if (n == 1) return nums[start];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
        for(int i=2;i<n;i++){
            int pick=nums[start+i]+dp[i-2];
            int nonpick=dp[i-1];
            dp[i]=Math.max(pick,nonpick);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
    int[] nums={1,2,3,1};
    int n=nums.length;
    int[] dp1=new int[n];
    int ans1=range(nums,dp1,0,n-2);

    int[] dp2=new int[n];
    int ans2=range(nums,dp2,1,n-1);

    System.out.println(Math.max(ans1,ans2));
    }
}
