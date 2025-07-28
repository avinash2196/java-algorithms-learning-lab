package meta.medium.TwoPointer;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int zeroCount = 0, maxLen = 0;

        while (right < nums.length) {
            if (nums[right] == 0) zeroCount++;

            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
 /*   Time and Space Complexity
    Metric	Value
    Time Complexity	O(n) — each index is visited at most twice
    Space Complexity	O(1) — constant space*/
}
