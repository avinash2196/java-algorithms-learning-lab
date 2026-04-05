package meta.medium;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        //find first pair where nums[i] is lesser than nums[i+1] ( we need to find first next larger from end)
        int lastGreaterIndex = nums.length - 2; //-2 as we need to check i+1 as well
        while (lastGreaterIndex >= 0 && nums[lastGreaterIndex + 1] <= nums[lastGreaterIndex]) {
            lastGreaterIndex--;
        }
        if (lastGreaterIndex >= 0) {
            //find first largest element than this to swap
            int largestIndex = nums.length - 1;
            while (nums[largestIndex] <= nums[lastGreaterIndex]) {
                largestIndex--;
            }
            swap(nums, largestIndex, lastGreaterIndex);

        }
        reverse(nums, lastGreaterIndex + 1);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int index) {
        int endIndex = nums.length - 1;
        int startIndex = index;
        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            endIndex--;
            startIndex++;

        }
    }
}
// Time complexity :O(n log n)
// Space Complexity :O(1)
