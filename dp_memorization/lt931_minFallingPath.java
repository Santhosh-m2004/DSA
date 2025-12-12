import java.util.*;

/*
Problem: Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row 
that is either directly below or diagonally left/right. Specifically, 
the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Input:
    3
    2 1 3
    6 5 4
    7 8 9

Expected Output:
    13
*/

public class lt931_minFallingPath {

    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int mini = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);

        for (int col = 0; col < n; col++)
            mini = Math.min(mini, recursion(0, col, m, n, matrix, dp));

        return mini;
    }

    public static int recursion(int row, int col, int m, int n, int[][] matrix, int[][] dp) {
        if (col < 0 || col >= n) return Integer.MAX_VALUE;
        if (row == m - 1) return matrix[row][col];
        if (dp[row][col] != Integer.MIN_VALUE) return dp[row][col];

        int a = recursion(row + 1, col - 1, m, n, matrix, dp);
        int b = recursion(row + 1, col, m, n, matrix, dp);
        int c = recursion(row + 1, col + 1, m, n, matrix, dp);

        return dp[row][col] = matrix[row][col] + Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.println(minFallingPathSum(matrix)); // Expected: 13
    }
}
