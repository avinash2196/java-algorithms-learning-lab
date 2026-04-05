package meta.medium;

public class DiagonalTraversal {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int rows = matrix.length, cols = matrix[0].length;
        int[] result = new int[rows * cols];

        int row = 0, col = 0, direction = 1;  // 1 = up-right, -1 = down-left

        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[row][col];

            int newRow = row + (direction == 1 ? -1 : 1);
            int newCol = col + (direction == 1 ? 1 : -1);

            // If out of bounds, change direction and adjust starting point
            if (newRow < 0 || newRow == rows || newCol < 0 || newCol == cols) {
                if (direction == 1) { // Up-right
                    if (col == cols - 1) {
                        row++;  // hit right wall
                    } else {
                        col++;  // move to next column
                    }
                } else { // Down-left
                    if (row == rows - 1) {
                        col++;  // hit bottom wall
                    } else {
                        row++;  // move to next row
                    }
                }
                direction *= -1; // Flip direction
            } else {
                row = newRow;
                col = newCol;
            }
        }

        return result;
    }
}
/*

    Time and Space Complexity
    Time Complexity: O(m * n) – Every element visited once

        Space Complexity: O(1) extra (excluding the output array)*/
