package leetcode;

// Description:
// Rotten Oranges Problem (LeetCode 994)
// Use BFS to spread rotting effect to fresh oranges.
// Return minimum time to rot all fresh oranges, otherwise return -1.

import java.util.*;

class Solution {

    class Node {
        int row;
        int col;
        int min;

        Node(int row, int col, int min) {
            this.row = row;
            this.col = col;
            this.min = min;
        }
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Node> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int oneCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = true;
                    q.add(new Node(i, j, 0));
                } else if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int time = 0;
        int cnt = 0;

        while (!q.isEmpty()) {

            Node cur = q.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            int curMin = cur.min;

            time = Math.max(time, curMin);

            for (int i = 0; i < 4; i++) {
                int newRow = curRow + dRow[i];
                int newCol = curCol + dCol[i];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    !vis[newRow][newCol] &&
                    grid[newRow][newCol] == 1) 
                {
                    vis[newRow][newCol] = true;
                    q.add(new Node(newRow, newCol, curMin + 1));
                    cnt++;
                }
            }
        }

        if (cnt < oneCount) return -1;

        return time;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] grid1 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println("Output 1: " + s.orangesRotting(grid1));  // Expected: 4

        int[][] grid2 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        System.out.println("Output 2: " + s.orangesRotting(grid2));  // Expected: -1
    }
}
