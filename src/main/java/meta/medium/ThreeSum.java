package meta.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    private List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(i, nums);
            }
        }
        return result;
    }

    private void twoSum(int index, int[] nums) {
        int left = index + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right] + nums[index];
            if (sum == 0) {
                result.add(Arrays.asList(nums[index], nums[left++], nums[right--]));
                while (left < right && nums[left - 1] == nums[left]) {
                    left++;
                }
                while (left < right && nums[right + 1] == nums[right]) {
                    right--;
                }
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}
