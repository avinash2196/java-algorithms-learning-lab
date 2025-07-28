package meta.medium.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphCycleIndegree {
    private int V;
    private List<List<Integer>> adj;

    public DirectedGraphCycleIndegree(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v); // Directed edge u → v
    }

    public boolean hasCycle() {
        int[] indegree = new int[V];
        //compute Indegree
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int numOfVisited = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            numOfVisited++;
            for (int u : adj.get(curr)) {
                indegree[u]--;
                if (indegree[u] == 0) {
                    queue.offer(u);
                }
            }
        }
        return numOfVisited == V;
    }
}
