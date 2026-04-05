package meta.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSwimWater {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == ROWS - 1 && curr[1] == COLS - 1) {
                return curr[2];
            }
            for (int[] d : dirs) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];
                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.add(new int[]{nr, nc, Math.max(curr[2], grid[nr][nc])});
                }
            }
        }
        return -1;
    }
}
