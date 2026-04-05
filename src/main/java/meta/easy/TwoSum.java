package meta.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum — LeetCode #1 (Easy)
 *
 * <p><b>Problem:</b> Given an array of integers {@code nums} and an integer {@code target},
 * return the indices of the two numbers that add up to {@code target}.
 *
 * <p><b>Concepts demonstrated:</b>
 * <ul>
 *   <li>HashMap for O(1) complement lookup (one-pass approach)</li>
 *   <li>Sort + binary search as an alternative trade-off</li>
 * </ul>
 *
 * <p><b>Real-world relevance:</b> Hash-based lookup is a foundational pattern used everywhere
 * — from database index scans to caching and deduplication pipelines.
 */
public class TwoSum {

    /**
     * One-pass HashMap approach.
     *
     * <p>For each element, checks whether its complement ({@code target - num}) already
     * exists in the map. If yes, we have our pair; otherwise, record {@code num → index}.
     *
     * <p><b>Trade-off:</b> Uses O(n) extra space to achieve O(n) time — a classic
     * space-for-time trade-off.
     *
     * @param nums   input array
     * @param target desired sum
     * @return indices of the two numbers, or an empty pair if none found
     *
     * <p>Time: O(n) | Space: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (seen.containsKey(target - num)) {
                return new int[]{index, seen.get(target - num)};
            }
            seen.put(num, index);
        }
        return new int[2];
    }

    /**
     * Sort + binary search approach.
     *
     * <p>Tracks original indices by pairing each value with its position, sorts by value,
     * then for each element uses binary search to find its complement.
     *
     * <p><b>Trade-off:</b> O(n log n) time but demonstrates how sorting enables binary
     * search and is useful when the array is already sorted or sorting is "free".
     *
     * @param nums   input array
     * @param target desired sum
     * @return indices of the two numbers, or an empty pair if none found
     *
     * <p>Time: O(n log n) | Space: O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        int[][] numArr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numArr[i][0] = nums[i];
            numArr[i][1] = i;
        }
        Arrays.sort(numArr, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < numArr.length - 1; i++) {
            int left = i + 1, right = numArr.length - 1;
            int complement = target - numArr[i][0];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numArr[mid][0] == complement) {
                    return new int[]{numArr[i][1], numArr[mid][1]};
                } else if (numArr[mid][0] < complement) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return new int[2];
    }
}
