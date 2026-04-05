package meta.medium;

import java.util.*;

public class ConituousSubArraySum {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // Base case: prefixSum 0 has occurred once

        for (int num : nums) {
            prefixSum += num;

            // Check if there's a prefix that satisfies (prefixSum - k)
            if (prefixMap.containsKey(prefixSum - k)) {
                count += prefixMap.get(prefixSum - k);
            }

            // Record the current prefix sum
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
