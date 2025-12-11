import java.util.*;

public class lt63_uniquePathsWithObstacles {

    /*
        Unique Paths II (LeetCode 63)

        A robot is placed in an m x n grid.
        Some cells contain obstacles (value = 1).
        The robot can move only right or down.

        Example:
        Input:
        [
          [0,0,0],
          [0,1,0],
          [0,0,0]
        ]

        Output: 2
    */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);

        return recursion(0, 0, m - 1, n - 1, dp, obstacleGrid);
    }

    public int recursion(int row, int col, int goalRow, int goalCol, int[][] dp, int[][] obstacleGrid) {

        if (row > goalRow || col > goalCol) return 0;

        if (obstacleGrid[row][col] == 1) return 0;

        if (row == goalRow && col == goalCol) return 1;

        if (dp[row][col] != -1) return dp[row][col];

        int down = recursion(row + 1, col, goalRow, goalCol, dp, obstacleGrid);
        int right = recursion(row, col + 1, goalRow, goalCol, dp, obstacleGrid);

        dp[row][col] = down + right;
        return dp[row][col];
    }

    public static void main(String[] args) {

        lt63_uniquePathsWithObstacles s = new lt63_uniquePathsWithObstacles();

        int[][] grid1 = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(s.uniquePathsWithObstacles(grid1)); // 2

        int[][] grid2 = {
            {0,1},
            {0,0}
        };
        System.out.println(s.uniquePathsWithObstacles(grid2)); // 1
    }
}
