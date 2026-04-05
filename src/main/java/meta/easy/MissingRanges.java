package meta.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            result.add(Arrays.asList(lower, upper));
            return result;
        }
        if (nums[0] > lower) {
            result.add(Arrays.asList(lower, nums[0] - 1));
        }
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index + 1] - nums[index] > 1) {
                result.add(Arrays.asList(nums[index] + 1, nums[index + 1] - 1));
            }
        }

        if (nums[nums.length - 1] < upper) {
            result.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }
    // Time complexity :O(n)
    // Space Complexity :O(k)-- k= gaps
}
