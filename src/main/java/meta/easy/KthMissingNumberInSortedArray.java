package meta.easy;

public class KthMissingNumberInSortedArray {
    public int findKthPositive(int[] arr, int k) {
        for (int num : arr) {
            if (num <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
// Time complexity :O(n)
// Space Complexity :O(1)