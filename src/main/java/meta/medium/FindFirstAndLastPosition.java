package meta.medium;

public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = findBound(nums, target, true);
        if (firstOccurrence == -1) return new int[]{-1, -1};
        int lastOccurrence = findBound(nums, target, false);
        return new int[]{firstOccurrence, lastOccurrence};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
// Time complexity :O(log n)
// Space Complexity :O(1)