package DP;
import java.util.*;

import arrays.reverse;
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

    static int res(int[][] nums,int days){
        int[][] dp=new int[days][days];
        



        return dp[0][days-1];
    }
    public static void main(String[] args) {
        int days=3;
        int[][] points={{10,40,70},{20,50,80},{30,60,90}};;
        System.out.println(res(points,days));
    }
}

