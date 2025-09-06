package graphs;
import java.util.*;

public class detectCycleUndirectedBFS {
    public static class Pair {
        int child;
        int parent;
        public Pair(int child, int parent) {
            this.child = child;
            this.parent = parent;
        }
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (hasCycle(i, visited, adj)) return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[i] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int child = cur.child;
            int parent = cur.parent;

            for (int node : adj.get(child)) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(new Pair(node, child));
                } else if (node != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(1); // cycle
        adj.get(1).add(4);

        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        boolean hasCycle = isCycle(V, adj);

        if (hasCycle) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}
