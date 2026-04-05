package meta.medium;

import java.util.*;

/**
 * Course Schedule — LeetCode #207 (Medium)
 *
 * <p><b>Problem:</b> Given {@code numCourses} and a list of prerequisite pairs, determine
 * whether it is possible to finish all courses (i.e., whether the graph has no cycle).
 *
 * <p><b>Concept:</b> Topological sort via Kahn's algorithm (BFS + in-degree tracking).
 * If all nodes can be visited in topological order, the graph is a DAG (no cycle).
 *
 * <p><b>Real-world relevance:</b> Topological ordering is used in build systems (Make,
 * Gradle), task schedulers, deployment pipelines, and package dependency resolution.
 *
 * <p>Time: O(V + E) | Space: O(V + E)
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap();
        for (int[] pre : prerequisites) {
            adj.computeIfAbsent(pre[1], k -> new ArrayList()).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;
            for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return nodesVisited == numCourses;
    }
}
// Time complexity : O(V+E)
// Space Complexity :O(V+E)