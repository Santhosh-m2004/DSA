package graphs;
import java.util.*;


public class numOfDistinctIslands1 {

    public int DistinctIslands(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=0;
            }
        }
        HashSet<ArrayList<String>> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    ArrayList<String> ans=new ArrayList<>();
                    dfs(i,j,ans,grid,visited,i,j);
                    set.add(ans);
                }
            }
        }
        return set.size();
    }

    public static String toString(int row,int col){
        return Integer.valueOf(row)+" "+Integer.valueOf(col);
    }

    public static  void dfs(int row,int col,ArrayList<String> ans,int[][] grid,int[][] visited,int baseRow,int baseCol){
        visited[row][col]=1;
        ans.add(toString(row - baseRow, col - baseCol));
        int n=grid.length;
        int m=grid[0].length;

        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nRow=row+dRow[i];
            int nCol=col+dCol[i];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && visited[nRow][nCol]==0){
                dfs(nRow, nCol, ans, grid, visited, baseRow, baseCol);
            }
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0}
        };

        numOfDistinctIslands1 obj = new numOfDistinctIslands1();
        int ans = obj.DistinctIslands(grid);
        System.out.println(ans);
    }
}
