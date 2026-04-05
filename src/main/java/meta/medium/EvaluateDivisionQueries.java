package meta.medium;

import java.util.*;

public class EvaluateDivisionQueries {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build bidirectional weighted graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / val);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                result[i] = -1.0;
            } else if (src.equals(dst)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, src, dst, 1.0, visited);
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double product, Set<String> visited) {
        if (current.equals(target)) return product;

        visited.add(current);

        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            if (visited.contains(neighbor.getKey())) continue;
            double result = dfs(graph, neighbor.getKey(), target, product * neighbor.getValue(), visited);
            if (result != -1.0) return result;
        }

        return -1.0;
    }
}
/*
        Time & Space Complexity
        Time Complexity:

        Building the graph: O(E) where E is the number of equations

        DFS per query: worst case O(V + E)

        Total: O(Q * (V + E)), where Q is number of queries

        Space Complexity:

        O(V + E) for the graph

        O(V) for the visited set during DFS*/
