package meta.easy;

public class SquareSumOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int pos = len - 1;
        int leftIndex = 0;
        int rightIndex = len - 1;
        int leftSq = 0;
        int rightSq = 0;
        int[] ans = new int[len];
        while (leftIndex <= rightIndex) {
            leftSq = nums[leftIndex] * nums[leftIndex];
            rightSq = nums[rightIndex] * nums[rightIndex];
            if (leftSq > rightSq) {
                ans[pos--] = leftSq;
                leftIndex++;
            } else {
                ans[pos--] = rightSq;
                rightIndex--;
            }
        }
        return ans;
    }
}
// Time complexity :O(n)
// Space Complexity :O(n)