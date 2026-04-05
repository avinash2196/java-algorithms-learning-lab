package meta.medium;

public class MinimumSizeSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            currSum += nums[right];
            while (currSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                currSum -= nums[left];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
// Time complexity : O(n)
// Space Complexity :O(1)