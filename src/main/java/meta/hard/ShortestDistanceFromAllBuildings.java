package meta.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    //since min so do BFS and find path to each building and keep on updating matrix for distance to find min from that
    public int shortestDistance(int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1,}, {-1, 0}};
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] total = new int[ROWS][COLS];
        int emptyLands = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{row, col});
                    int steps = 0;
                    while (!queue.isEmpty()) {
                        steps++;
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            int[] curr = queue.poll();
                            for (int[] dir : directions) {
                                int newRow = curr[0] + dir[0];
                                int newCol = curr[1] + dir[1];
                                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && grid[newRow][newCol] == emptyLands) {
                                    grid[row][col]--;
                                    total[newRow][newCol] += steps;
                                    queue.offer(new int[]{newRow, newCol});
                                }
                            }
                        }
                    }
                    emptyLands--;
                }
            }
        }
        int minDistance = Integer.MIN_VALUE;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                minDistance = Math.min(minDistance, total[row][col]);
            }
        }
        return minDistance == Integer.MIN_VALUE ? -1 : minDistance;
    }
}
/*
Time: O(B × R × C), where B = number of buildings, R × C = grid size

        Space: O(R × C) for total matrix + BFS queue*/
