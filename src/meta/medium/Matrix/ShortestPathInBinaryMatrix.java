package meta.medium.Matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    private int ROW = 0;
    private int COL = 0;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        if (grid[0][0] != 0 || grid[ROW - 1][COL - 1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currDistance = grid[curr[0]][curr[1]];
            if (curr[0] == ROW - 1 && curr[1] == COL - 1) {
                return currDistance;
            }
            for (int[] neighbour : getNeighbours(curr[0], curr[1], grid)) {
                queue.add(new int[]{neighbour[0], neighbour[1]});
                grid[neighbour[0]][neighbour[1]] = currDistance + 1;
            }
        }
        return -1;
    }

    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<int[]>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newRow >= ROW || newCol < 0 || newCol >= COL || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }
}

/*    Time Complexity: O(n*n)

        Space Complexity: O(n*n)*/
