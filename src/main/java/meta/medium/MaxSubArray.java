package meta.medium;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxArraySum = nums[0];
        int currArraySum = nums[0];
        for (int index = 1; index < nums.length; index++) {
            int num = nums[index];
            currArraySum = Math.max(currArraySum, currArraySum + num);
            maxArraySum = Math.max(currArraySum, maxArraySum);
        }
        return maxArraySum;
    }
}
// Time complexity :O(n)
// Space Complexity :O(1)