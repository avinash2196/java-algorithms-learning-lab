package meta.hard;

public class MaxSumofThreeSubArrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] windowSum = new int[n - k + 1];
        int currWindowSum = 0;
        for (int i = 0; i < n; i++) {
            currWindowSum += nums[i];
            if (i >= k) {
                currWindowSum -= nums[i - k];
            }
            if (i >= k - 1) {
                windowSum[i - k + 1] = currWindowSum;
            }
        }
        int[] left = new int[windowSum.length];
        int bestLeft = 0;
        for (int i = 0; i < windowSum.length; i++) {
            if (windowSum[i] > windowSum[bestLeft]) {
                bestLeft = i;
            }
            left[i] = bestLeft;
        }
        int[] right = new int[windowSum.length];
        int bestRight = windowSum.length - 1;
        for (int i = windowSum.length - 1; i >= 0; i++) {
            if (windowSum[i] > windowSum[bestRight]) {
                bestRight = i;
            }
            right[i] = bestRight;
        }
        int[] result = new int[3];
        int maxSum = 0;
        for (int mid = k; mid <= windowSum.length - k - 1; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];
            int total = windowSum[l] + windowSum[mid] + windowSum[r];
            if (total > maxSum) {
                maxSum = total;
                result[0] = l;
                result[1] = mid;
                result[2] = r;
            }
        }
        return result;
    }
}
