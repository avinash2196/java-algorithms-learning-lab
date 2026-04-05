package meta.hard;

public class MaxIncreasingPath {
    private int m, n;
    private int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        //keep on finding next big and keep on increasing if we find one by using dfs
        if (matrix.length == 0)
            return 0;
        n = matrix.length;
        m = matrix[0].length;
        memo = new int[n][m];
        int maxPath = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) return memo[row][col];
        int maxPath = 1;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[newCol][newCol] > matrix[row][col]) {
                maxPath = Math.max(maxPath, dfs(matrix, newRow, newCol) + 1);
            }
        }
        memo[row][col] = maxPath;
        return maxPath;
    }
}
