package DP;
import java.util.*;
/*Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. 
At a time the frog can climb either one or two steps. A height[N] array is also given. 
Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]).
We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1. */
public class frog_jump {
    public static void main(String[] args) {
        int height[]={30,10,60,10,60,50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<n;i++){
            int jumpOne=dp[i-1]+Math.abs(height[i]- height[i-1]);
            int jumpTwo=Integer.MAX_VALUE;
            if(i>1){
                jumpTwo=dp[i-2]+Math.abs(height[i]- height[i-2]);
            }
            dp[i]=Math.min(jumpOne, jumpTwo);
        }
        System.out.println(dp[n-1]);
    }
}
