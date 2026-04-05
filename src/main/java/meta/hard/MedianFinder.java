package meta.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find Median from Data Stream — LeetCode #295 (Hard)
 *
 * <p><b>Problem:</b> Design a data structure that supports adding integers from a
 * data stream and retrieving the median at any time.
 *
 * <p><b>Concept:</b> Two-heap partition. Maintain a max-heap {@code left} for the
 * lower half and a min-heap {@code right} for the upper half, keeping their sizes
 * balanced (|left| - |right| ≤ 1). The median is either the top of the larger heap
 * or the average of both tops.
 *
 * <p><b>Real-world relevance:</b> Online/streaming median is used in monitoring
 * dashboards, percentile latency tracking (p50), and real-time analytics pipelines
 * where you cannot afford to re-sort the entire dataset on each insertion.
 *
 * <p>Time: O(log n) per insert, O(1) per query | Space: O(n)
 */
public class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    MedianFinder() {//initializes the MedianFinder object.
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    void addNum(int num) { //adds the integer num from the data stream to the data structure.
        left.offer(num);
        if (!right.isEmpty() && right.peek() < left.peek()) {
            right.offer(left.poll());
        }
        if (left.size() - right.size() > 1) {
            right.offer(left.poll());
        } else if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    double findMedian() {// returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
        if (left.size() == right.size()) return left.peek() + right.peek() / 2;
        else return left.peek();
    }
}
