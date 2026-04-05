package meta.medium;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        // Min-heap that stores [value, row, column]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Initialize heap with the first element of each row (up to k rows)
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        // Extract min k times
        int[] current = new int[3];
        while (k-- > 0) {
            current = minHeap.poll();
            int row = current[1];
            int col = current[2];

            // Add next element in the row if it exists
            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return current[0];
    }
}
/*
    Time Complexity: O(k log n)

        Each heap operation is log n, and we do this k times

        Space Complexity: O(n)

        The heap holds at most one element from each of the n rows*/
