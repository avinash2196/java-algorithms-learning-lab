package meta.medium.TwoPointer;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        //use two pointer one for each list ..keep on finding intersection and move ahead the one which exhausts
        int aIndex = 0;
        int aLength = A.length;
        int bIndex = 0;
        int bLength = B.length;
        List<int[]> resultList = new ArrayList<>();
        while (aIndex < aLength && bIndex < bLength) {
            int startIndex = Math.max(A[aIndex][0], B[bIndex][0]);
            int endIndex = Math.min(A[aIndex][1], B[bIndex][1]);
            if (endIndex >= startIndex) {
                resultList.add(new int[]{startIndex, endIndex});
            }
            if (A[aIndex][1] > B[bIndex][1]) {
                bIndex++;
            } else {
                aIndex++;
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

	/* firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]


*/
}
/*
* Time & Space Complexity
Time Complexity: O(m + n)

Each element in A and B is visited at most once.

Space Complexity: O(min(m, n))

In the worst case, every pair could intersect.
* */
