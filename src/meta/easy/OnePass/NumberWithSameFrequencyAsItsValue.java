package meta.easy.OnePass;

import java.util.HashMap;
import java.util.Map;

public class NumberWithSameFrequencyAsItsValue {
    class Solution {
        public int findLucky(int[] arr) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : arr) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
            int maxNumber = -1;
            for (Map.Entry<Integer, Integer> mapEntry : freqMap.entrySet()) {
                if (mapEntry.getKey() == mapEntry.getValue()) {
                    maxNumber = Math.max(mapEntry.getKey(), maxNumber);
                }
            }
            return maxNumber;
        }
    }
}
/*
Time Complexity : O(n)
Space Complexity : O(n)
 */
