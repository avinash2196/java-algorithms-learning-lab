package meta.easy;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int index = 0; index < nums.length; index++) {
            ans[index] = nums[index];
            ans[index + n] = nums[index];
        }
        return ans;
    }
}
// Time complexity :O(n)
// Space Complexity :O(n)