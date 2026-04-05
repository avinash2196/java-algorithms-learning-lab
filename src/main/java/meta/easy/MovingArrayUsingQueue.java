package meta.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingArrayUsingQueue {
    class MovingAverage {
        int size = 0;
        int windowSum = 0;
        Queue<Integer> queue = new ArrayDeque<Integer>();

        MovingAverage(int size) {// Initializes the object with the size of the window size.
            this.size = size;
        }

        double next(int val) {// Returns the moving average of the last size values of the stream.
            if (queue.size() == size) {
                windowSum -= queue.poll();
            }
            queue.add(val);

            windowSum += val;
            return (1.0 * windowSum) / queue.size();
        }
    }
    // Time complexity :O(1)
    // Space Complexity :O(n)
}
