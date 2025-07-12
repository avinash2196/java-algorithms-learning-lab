package meta.medium.OnePass;

import java.util.*;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // Base case: prefixSum 0 has occurred once
//basic idea is if sum at index i and sum at index j are at k apart that means sum between i and j is k
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
/*
Time & Space Complexity
        Metric	Complexity
        Time	O(n)
        Space (HashMap)	O(n)*/
