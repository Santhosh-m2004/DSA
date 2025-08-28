package DP;
import java.util.*;
/*A Ninja has an ‘N’ Day training schedule. 
He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day. 
There are merit points associated with performing an activity each day. 
The same activity can’t be performed on two consecutive days. 
We need to find the maximum merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity on that particular day. 
Our task is to calculate the maximum number of merit points that the ninja can earn.

example:
    days=3
    points={{10,40,70},{20,50,80},{30,60,90}};
    
    output=210 {70+50+90}
*/
public class ninjaTraining {
    // Approach 1
    static int res(int[][] nums,int days){
        int[][] dp=new int[nums.length][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        int res=recursion(nums, nums.length-1, 3,dp);
        return res;
    }
    public static int recursion(int[][] nums,int day,int last,int[][] dp){
        
        if(day==0){
            int max=0;
            for(int i=0;i<=2;i++){
                if(i!=last){
                    max=Math.max(max,nums[day][i]);
                }
            }
            return max;
        }
        if(dp[day][last]!=-1) return dp[day][last];

        int max=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int points=nums[day][i]+recursion(nums,day-1,i,dp);
                max=Math.max(max,points);
            }
        }
        return dp[day][last]=max;
    }


    //Approach 2
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];

        // Base case for day 0
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Fill the DP table
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    

    public static void main(String[] args) {
        int days=3;
        int[][] points={{10,40,70},{20,50,80},{30,60,90}};;
        System.out.println(res(points,days));

        System.out.println(ninjaTraining(days, points));
    }
}

