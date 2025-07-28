package meta.easy.Design;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList();
        }

        public int ping(int t) {
            queue.offer(t);
            while (t - queue.peek() > 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
/*
1
q[1]
100 ->q[1,100]
30001->q[1,100,3001] 3001-1>3000 false
30002->q[1,100,3001,3002] 3002-1>3000 true
*/

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
