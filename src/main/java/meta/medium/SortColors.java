package meta.medium;

public class SortColors {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int index = 0;
        int temp = 0;
        while (index <= twoIndex) {
            if (nums[index] == 0) {
                temp = nums[zeroIndex];
                nums[zeroIndex++] = nums[index];
                nums[index++] = temp;
            } else if (nums[index] == 2) {
                temp = nums[twoIndex];
                nums[twoIndex--] = nums[index];
                nums[index++] = temp;
            } else {
                index++;
            }
        }
    }
}
// Time complexity :O(n)
// Space Complexity :O(1)