package meta.medium.Graph;

import java.util.*;

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