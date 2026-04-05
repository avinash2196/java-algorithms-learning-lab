package meta.medium;

public class RemoveDuplicateFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 1;
        int uniqueIndex = 1;
        int count = 1;
        while (index < nums.length) {
            if (nums[index] == nums[index - 1]) {
                count++;
                if (count > 2) {
                    index++;
                    continue;
                }
            } else {
                count = 1;
            }
            nums[uniqueIndex++] = nums[index++];
        }
        return uniqueIndex;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int uniqueIndex = 2; // First two elements are always allowed

        for (int i = 2; i < nums.length; i++) {
            // Only allow nums[i] if it's not the same as nums[uniqueIndex - 2]
            if (nums[i] != nums[uniqueIndex - 2]) {
                nums[uniqueIndex++] = nums[i];
            }
        }

        return uniqueIndex;
    }
}

// Time complexity :O(n)
// Space Complexity :O(1)