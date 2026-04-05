package meta.medium;

import java.util.*;

public class MazeProblem {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int ROWS = maze.length, COLS = maze[0].length;

        // Directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];

        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];

            if (r == destination[0] && c == destination[1]) return true;

            for (int[] dir : directions) {
                int row = r, col = c;

                // Keep rolling in the current direction
                while (row + dir[0] >= 0 && row + dir[0] < ROWS && col + dir[1] >= 0 && col + dir[1] < COLS && maze[row + dir[0]][col + dir[1]] == 0) {
                    row += dir[0];
                    col += dir[1];
                }

                if (!visited[row][col]) {
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
        }

        return false;
    }

}
/*
    Time Complexity: O(m * n)
        Each cell is visited at most once due to the visited array.

        Space Complexity: O(m * n)
        For the visited array and BFS queue*/
