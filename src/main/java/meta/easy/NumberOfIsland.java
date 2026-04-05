package meta.easy;

public class NumberOfIsland {
    public int islandPerimeter(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int perimeter = 0;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (grid[row][col] == 1) {
                    perimeter += 4;
                    if (row > 0 && grid[row - 1][col] == 1) perimeter -= 2;
                    if (col > 0 && grid[row][col - 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
// Time complexity :O(m*n)
// Space Complexity :O(1)
}
