package meta.easy;

public class RemoveDuplicatesFromSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            //iterate and keep track of nonduplicate and keep on shiftig non duplicates to left
            int nonDuplicateIndex=1;
            for(int index=1;index<nums.length;index++){
                if(nums[index]!=nums[index-1]){
                    nums[nonDuplicateIndex++]=nums[index];
                }
            }
            return nonDuplicateIndex;
        }
    }
    // Time complexity :O(n)
    // Space Complexity :O(1)
}
