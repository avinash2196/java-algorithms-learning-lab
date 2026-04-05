package meta.medium;

import java.util.*;

public class ContinousSubarraySum {


    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1);  // Handle case when subarray starts at index 0

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // To handle k = 0 edge case
            if (k != 0) {
                prefixSum %= k;
            }

            if (remainderIndexMap.containsKey(prefixSum)) {
                int prevIndex = remainderIndexMap.get(prefixSum);
                if (i - prevIndex > 1) {
                    return true;
                }
            } else {
                remainderIndexMap.put(prefixSum, i);
            }
        }

        return false;
    }
}
/*    Time Complexity: O(n)

        Space Complexity: O(min(n, k)) — since remainders are bounded by k values*/
