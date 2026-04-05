package meta.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int required = nums.length / 2;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > required) {
                return num;
            }
        }

        return 0; // Should never be reached if majority is guaranteed
    }

    // Time complexity :O(n)
    // Space Complexity :O(n)
}
