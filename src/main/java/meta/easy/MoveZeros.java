package meta.easy;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                nums[nonZeroIndex++] = nums[index];
            }
        }
        for (int index = nonZeroIndex; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
// Time complexity :O(n)
// Space Complexity :O(1)
}
