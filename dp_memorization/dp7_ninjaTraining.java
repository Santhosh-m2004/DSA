import java.util.*;

/*
    Ninja Training Problem
    -----------------------
    You are given 'n' days and 3 tasks each day.
    You must choose one task per day but cannot repeat the same task on consecutive days.
    Maximize the total points.

    Approach:
    Memoization (Top-Down DP)
*/

public class dp7_ninjaTraining {

    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4]; 
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recursion(n - 1, points, 3, dp);
    }

    public static int recursion(int day, int[][] points, int last, int[][] dp) {

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }

        if (dp[day][last] != -1) return dp[day][last];

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int curPoints = points[day][i] + recursion(day - 1, points, i, dp);
                maxi = Math.max(maxi, curPoints);
            }
        }

        dp[day][last] = maxi;
        return maxi;
    }

    public static void main(String[] args) {

        int[][] points1 = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };
        System.out.println(ninjaTraining(3, points1)); // Expected: 210

        int[][] points2 = {
            {2, 1, 3},
            {4, 6, 8},
            {5, 7, 9}
        };
        System.out.println(ninjaTraining(3, points2)); // Expected Output: 3+8+9 = 20
    }
}
