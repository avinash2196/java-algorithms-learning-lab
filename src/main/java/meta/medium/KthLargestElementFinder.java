package meta.medium;

import java.util.PriorityQueue;

public class KthLargestElementFinder {

    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the k largest elements seen so far ( min at top)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest to keep heap size at k
            }
        }

        return minHeap.peek(); // The kth largest element
    }
}
// Time complexity : O(n log n)
// Space Complexity :O(1)