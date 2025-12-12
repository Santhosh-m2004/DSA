import java.util.*;

public class lt120_minimumTotal {

    /*
        Triangle Minimum Path Sum (LeetCode 120)

        You are given a triangle array.
        Starting from the top, move to adjacent numbers on the next row.
        Return the minimum path sum from top to bottom.

        Example:
        Input:
        [
            [2],
            [3,4],
            [6,5,7],
            [4,1,8,3]
        ]

        Output: 11
        Explanation: 2 + 3 + 5 + 1 = 11
    */

    public  int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        return recursion(0, 0, triangle, dp);
    }

    public  int recursion(int row, int col, List<List<Integer>> triangle, int[][] dp) {

        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int down = recursion(row + 1, col, triangle, dp);
        int diag = recursion(row + 1, col + 1, triangle, dp);

        dp[row][col] = triangle.get(row).get(col) + Math.min(down, diag);

        return dp[row][col];
    }


    public static void main(String[] args) {
        lt120_minimumTotal obj = new lt120_minimumTotal();

        List<List<Integer>> triangle1 = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );
        System.out.println(obj.minimumTotal(triangle1)); // 11

        List<List<Integer>> triangle2 = Arrays.asList(
            Arrays.asList(-1),
            Arrays.asList(2, 3),
            Arrays.asList(1, -1, -3)
        );
        System.out.println(obj.minimumTotal(triangle2)); // -1
    }
}
