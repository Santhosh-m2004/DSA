package graphs;
import java.util.*;
public class isGraphBartite {

    public static boolean isBartite(int[][] graph){
        int v=graph.length;
        int[] colors=new int[v];
        Arrays.fill(colors,-1);
        for(int i=0;i<v;i++){
            if(colors[i]==-1){
                if(check(i,v,graph,colors)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int start,int v,int[][] graph,int[] colors){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        colors[start]=0;

        while(!q.isEmpty()){
            int cur=q.poll();

            int[] temp=graph[cur];
            for(int num:temp){
                if(colors[num]==-1){
                    q.add(num);
                    colors[num]=1-colors[cur];
                }else if(colors[num]==colors[cur]){
                    return false;
                }
            }
        }
        return true;

    }
    public static void main(String[] args) {
        int[][] graph ={{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBartite(graph));
    }
}
