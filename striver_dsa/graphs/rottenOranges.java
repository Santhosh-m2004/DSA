package graphs;
import java.util.*;
public class rottenOranges {
    static class container{
        int row;
        int col;
        int time;

        public container(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }

    public static int orangesRotting(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        Queue<container> q=new LinkedList<>();
        int freshCnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=0;
                if(grid[i][j]==2){
                    q.offer(new container(i, j, 0));
                    visited[i][j]=1;
                }
                if(grid[i][j]==1) freshCnt++;
            }
        }
        
        int maxTime=0;
        int count=0;

        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};

        while(!q.isEmpty()){
            container curr=q.poll();

            int row=curr.row;
            int col=curr.col;
            int time=curr.time;

            maxTime=Math.max(maxTime,time);
            for(int i=0;i<4;i++){
                int newRow=row+dRow[i];
                int newCol=col+dCol[i];

                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && visited[newRow][newCol]==0 && grid[newRow][newCol]==1){
                    visited[newRow][newCol]=1;
                    q.offer(new container(newRow, newCol, time+1));
                    count++;
                }
            }
        }
        if(count<freshCnt) return -1;
        return maxTime;
    }
    public static void main(String[] args) {
        rottenOranges obj = new rottenOranges();

        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        System.out.println(obj.orangesRotting(grid)); // Expected output: 4
    }
}
