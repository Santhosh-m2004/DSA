import java.util.*;

public class lt64_minPathSum {

    /*
        Minimum Path Sum (LeetCode 64)

        A grid of size m x n contains non-negative numbers.
        You start at (0,0) and can move only right or down.

        Return the minimum path sum to reach (m-1,n-1).

        Example:
        Input:
        [
          [1,3,1],
          [1,5,1],
          [4,2,1]
        ]

        Output: 7
    */

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);

        return recursion(0, 0, m - 1, n - 1, grid, dp);
    }

    public int recursion(int row, int col, int goalRow, int goalCol, int[][] grid, int[][] dp) {

        if (row > goalRow || col > goalCol) return Integer.MAX_VALUE;
        if (row == goalRow && col == goalCol) return grid[row][col];

        if (dp[row][col] != -1) return dp[row][col];

        int down = recursion(row + 1, col, goalRow, goalCol, grid, dp);
        int right = recursion(row, col + 1, goalRow, goalCol, grid, dp);

        dp[row][col] = grid[row][col] + Math.min(down, right);;

        return dp[row][col];
    }

    public static void main(String[] args) {
        lt64_minPathSum s = new lt64_minPathSum();

        int[][] grid1 = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        System.out.println(s.minPathSum(grid1)); // 7

        int[][] grid2 = {
            {1,2},
            {1,1}
        };
        System.out.println(s.minPathSum(grid2)); // 3
    }
}
