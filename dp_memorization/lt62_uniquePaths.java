import java.util.*;

public class lt62_uniquePaths {

    /*
        Unique Paths (LeetCode 62)
        A robot moves only right or down in an m x n grid.
        Find the number of unique paths from (0,0) to (m-1,n-1).

        Input:
        m = 3, n = 7

        Output:
        28
    */

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recursion(0, 0, m - 1, n - 1, dp);
    }

    public int recursion(int row, int col, int goalRow, int goalCol, int[][] dp) {
        if (row == goalRow && col == goalCol) return 1;
        if (row > goalRow || col > goalCol) return 0;
        if (dp[row][col] != -1) return dp[row][col];

        int down = recursion(row + 1, col, goalRow, goalCol, dp);
        int right = recursion(row, col + 1, goalRow, goalCol, dp);

        dp[row][col] = down + right;
        return dp[row][col];
    }

    public static void main(String[] args) {
        lt62_uniquePaths s = new lt62_uniquePaths();

        System.out.println(s.uniquePaths(3, 7)); // 28
        System.out.println(s.uniquePaths(3, 2)); // 3
    }
}
