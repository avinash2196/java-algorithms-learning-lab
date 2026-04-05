package meta.hard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        //use dualheap to take care of this
        //simply add and remove from dual heap if i>=k

        DualHeap dh = new DualHeap(k);
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            dh.add(nums[i]);

            //remove if we have more elements on heap
            if (i >= k) {
                dh.remove(nums[i - k]);
            }
            //find median for every i-k+1
            if (i + 1 >= k) {
                result[i - k + 1] = dh.getMedian();
            }
        }
        return result;
    }
}

class DualHeap {
    PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> high = new PriorityQueue<>();
    Map<Integer, Integer> delayed = new HashMap<>();
    int k = 0;
    int lowSize = 0;
    int highSize = 0;

    DualHeap(int k) {
        this.k = k;
    }

    public void add(int num) {
        if (low.isEmpty() || num < low.peek()) {
            low.add(num);
            lowSize++;
        } else {
            high.add(num);
            highSize++;
        }
        rebalance();
    }

    public void remove(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (num < low.peek()) {
            lowSize--;
            if (num == low.peek()) prune(low);
        } else {
            highSize--;
            if (num == high.peek()) prune(high);
        }
        rebalance();
    }

    private void rebalance() {
        if (lowSize - highSize > 1) {
            high.add(low.poll());
            highSize++;
            lowSize--;
            prune(low);
        } else if (lowSize < highSize) {
            low.add(high.poll());
            lowSize++;
            highSize--;
            prune(high);
        }
    }

    private void prune(PriorityQueue<Integer> queue) {
        while (!queue.isEmpty()) {
            int top = queue.peek();
            if (delayed.containsKey(top)) {
                delayed.put(top, delayed.get(top) - 1);
                if (delayed.get(top) == 0)
                    delayed.remove(top);
                queue.poll();
            } else {
                break;
            }
        }
    }

    double getMedian() {
        if (k % 2 == 0) {
            return (long) (low.peek() + high.peek()) / 2.0;
        } else
            return low.peek();
    }


}
