package meta.medium.Design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromStream {
    public class MovingAverage {
        private int size;
        Queue<Integer> queue;
        private int windowSum;

        public MovingAverage(int size) {
            this.size = size;
            this.queue = new LinkedList<>();//use queue as we need FIFO
            this.windowSum = 0;
        }

        public double next(int val) {
            //keep only k element in queue and also same element in windowSum
            if (queue.size() == size) {
                windowSum -= queue.poll();
            }
            windowSum += val;
            queue.offer(val);
            return 1.0 * windowSum / queue.size();
        }
    }
  /*  Time & Space Complexity:
    Operation	Time Complexity	Space Complexity
    next(val)	O(1)	O(k)*/
}
