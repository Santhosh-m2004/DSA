package graphs;
import java.util.*;

public class numberOfIslands {
    static class Container {
        int row, col;
        public Container(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void bfs(int row, int col, int[][] visited, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        Queue<Container> q = new LinkedList<>();
        q.offer(new Container(row, col));
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Container cur = q.poll();
            int curRow = cur.row;
            int curCol = cur.col;

            for (int i = 0; i < 4; i++) {
                int newRow = curRow + dRow[i];
                int newCol = curCol + dCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == 0 && grid[newRow][newCol] == '1') {
                    visited[newRow][newCol] = 1;
                    q.offer(new Container(newRow, newCol));
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        System.out.println("Number of Islands: " + numIslands(grid)); // Expected: 3
    }
}
