package graphs;
import java.util.*;

public class topologicalSort {

    public static ArrayList<Integer> topoSort(int[][] graph) {
        int V = graph.length;
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, graph, visited, st);
            }
        }

        ArrayList<Integer> lst = new ArrayList<>();
        while (!st.isEmpty()) {
            lst.add(st.pop());
        }

        return lst;
    }

    public static void dfs(int start, int[][] graph, int[] visited, Stack<Integer> st) {
        visited[start] = 1;
        for (int num : graph[start]) { // iterate neighbors directly
            if (visited[num] == 0) {
                dfs(num, graph, visited, st);
            }
        }
        st.push(start);
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

        System.out.println(topoSort(graph));
    }
}
