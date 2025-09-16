package graphs;
import java.util.*;

public class topologicalSortBFS {

    public static ArrayList<Integer> BFS(int[][] graph) {
        int V = graph.length;
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int num:graph[i]){
                indegree[num]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        ArrayList<Integer> lst = new ArrayList<>();
        while(!q.isEmpty()){
            int cur=q.poll();
            lst.add(cur);
            for(int num:graph[cur]){
                indegree[num]--;
                if(indegree[num]==0){
                    q.add(num);
                }
            }
        }
        return lst;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {},        // 0 has no outgoing edges
            {},        // 1 has no outgoing edges
            {3},       // 2 -> 3
            {1},       // 3 -> 1
            {0, 1},    // 4 -> 0, 1
            {0, 2}     // 5 -> 0, 2
        };

        System.out.println(BFS(graph));
    }
}
