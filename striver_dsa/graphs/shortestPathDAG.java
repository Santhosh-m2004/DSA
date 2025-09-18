package graphs;
import java.util.*;
public class shortestPathDAG {
  static class Pair{
    int node;
    int weight;
    public Pair(int node,int weight){
      this.node=node;
      this.weight=weight;
    }
  }

  public static int[] shortestPath(int n,int m,int[][] edge){
    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){
      adj.add(new ArrayList<>());
    }
    for(int[] arr:edge){
      int n1=arr[0];
      int n2=arr[1];
      int we=arr[2];
      adj.get(n1).add(new Pair(n2, we));
    }
    int[] visited=new int[n];
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<n;i++){
      if(visited[i]==0){
        topo(i,adj,visited,st);
      }
    }
    int[] dist=new int[n];
    for(int k=0;k<n;k++){
      dist[k]=Integer.MAX_VALUE;
    }
    dist[0]=0;
    while(!st.isEmpty()){
      int node=st.pop();

      for(int i=0;i<adj.get(node).size();i++){
        int v=adj.get(node).get(i).node;
        int wt=adj.get(node).get(i).weight;

        if(dist[node]+wt<dist[v]){
          dist[v]=dist[node]+wt;
        }
      } 
    }

    for (int i = 0; i < n; i++) {
      if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
    }
      
    return dist;
  }

  public static void topo(int start,ArrayList<ArrayList<Pair>> adj,int[] visited,Stack<Integer> st){
    visited[start]=1;
    for(int i=0;i<adj.get(start).size();i++){
      int v=adj.get(start).get(i).node;
      if(visited[v]==0){
        topo(v,adj,visited,st);
      }
    }
    st.push(start);
  }
    public static void main(String[] args){
    int n = 6, m = 7;
    int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
    int res[] = shortestPath(n, m, edge);
    for (int i = 0; i < n; i++) {
      System.out.print(res[i] + " ");
    }
    System.out.println();
  }
}
