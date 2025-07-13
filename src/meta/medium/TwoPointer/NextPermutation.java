package meta.medium.TwoPointer;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1){
            return ;
        }

        //find first a pair of decresing element from last
        int firstSmallElementIndex=n-2;
        while(firstSmallElementIndex>=0 && nums[firstSmallElementIndex+1]<=nums[firstSmallElementIndex]){
            firstSmallElementIndex--;
        }
        //find next Largest Element to swap from last
        if(firstSmallElementIndex>=0){
            int nextLargestElementIndex=n-1;
            while(nums[firstSmallElementIndex]>=nums[nextLargestElementIndex]){
                nextLargestElementIndex--;
            }
            swap(nums,firstSmallElementIndex,nextLargestElementIndex);
        }
        reverse(nums,firstSmallElementIndex+1);
    }
    private void swap(int[] nums,int firstIndex,int secondIndex){
        int temp=nums[firstIndex];
        nums[firstIndex]=nums[secondIndex];
        nums[secondIndex]=temp;
    }
    private void reverse(int[] nums, int index){
        int endIndex=nums.length-1;
        int startIndex=index;
        while(startIndex<endIndex){
            swap(nums,startIndex++,endIndex--);
        }
    }

	/*
	1257643
	1324567

	123
	132

	125431
	125
	13
	135421
	131245

	*/
}
// Time complexity :O(n)
// Space Complexity :O(1)
