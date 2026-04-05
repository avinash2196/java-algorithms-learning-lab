package meta.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<Integer>();
        for(int index=0;index<nums.length;index++){
            if(set.contains(nums[index])){
                return true;
            }
            set.add(nums[index]);
            if(set.size()>k){
                set.remove(nums[index-k]);
            }
        }
        return false;
    }
    // Time complexity :O(n)
    // Space Complexity :O(k)
}
