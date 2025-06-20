package graphs;
import java.util.*;

class bfs{

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int n, int start){
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+" ");
            for(int it: adj.get(node)){
                if(!visited[it]){
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int start = sc.nextInt();
        bfs(adj,n,start);
        sc.close();
    }
}