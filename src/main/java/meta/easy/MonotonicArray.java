package meta.easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int globalCompare = 0;
        for (int index = 0; index < nums.length - 1; index++) {
            int compare = Integer.compare(nums[index], nums[index + 1]);
            if (compare != 0) {
                if (globalCompare != 0 && compare != globalCompare) {
                    return false;
                }
                globalCompare = compare;
            }
        }
        return true;
    }
}
// Time complexity :O(n)
// Space Complexity :O(1)
