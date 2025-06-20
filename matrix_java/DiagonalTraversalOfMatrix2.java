package matrix_java;

import java.util.*;

class DiagonalTraversalOfMatrix2 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int index = 0;

        for (int d = 0; d < m + n - 1; d++) {
            if (d % 2 == 0) {
                int row = Math.min(d, m - 1);
                int col = d - row;
                while (row >= 0 && col < n) {
                    result[index++] = matrix[row][col];
                    row--;
                    col++;
                }
            } else {
                int col = Math.min(d, n - 1);
                int row = d - col;
                while (row < m && col >= 0) {
                    result[index++] = matrix[row][col];
                    row++;
                    col--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DiagonalTraversalOfMatrix2 solution = new DiagonalTraversalOfMatrix2();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[] result = solution.findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(result));
    }
}