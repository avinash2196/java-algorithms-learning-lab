package meta.hard;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //max heap based on nums by storing indices
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        int[] ans = new int[n - k + 1];
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.offer(i);

            //removing from top if heap top is less i-k
            while (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.remove();
            }
            //if heap i-k is more ,start storing result

            if (i + 1 >= k) {
                ans[startIndex++] = nums[queue.peek()];
            }

        }
        return ans;

    }
}
