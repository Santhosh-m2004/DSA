package graphs;
import java.util.*;

public class BFS {
    static int vertices;
    static LinkedList<Integer>[] adjList;

    // Initialize the graph
    public static void initGraph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge to the graph (undirected)
    public static void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // Remove this line if graph is directed
    }

    // BFS traversal from a given start node
    public static void bfsTraversal(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        System.out.print("BFS traversal starting from node " + start + ": ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        initGraph(6); // Create graph with 6 vertices (0 to 5)

        // Add edges
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(4, 5);

        // Perform BFS
        bfsTraversal(0);
    }

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of vertices and edges
        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        initGraph(v);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        // Read all edges
        System.out.println("Enter " + e + " edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int vtx = sc.nextInt();
            addEdge(u, vtx);
        }

        // Read starting node for BFS
        System.out.print("Enter starting node for BFS: ");
        int start = sc.nextInt();

        // Perform BFS
        bfsTraversal(start);

        sc.close();
    }
     */
}
