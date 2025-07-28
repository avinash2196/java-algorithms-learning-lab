package meta.medium.Graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphCycleDFS {
    private int V;
    private List<List<Integer>> adj;

    public UndirectedGraphCycleDFS(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, node)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

}
