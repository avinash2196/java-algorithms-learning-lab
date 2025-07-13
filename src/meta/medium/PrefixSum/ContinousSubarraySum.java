package meta.medium.PrefixSum;

import java.util.*;

public class ContinousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefix = 0;
        //map of mod of prefix to index
        //using (sum[i]-sum[j)%k==0
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1); //needed to ensure we use first % k
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % k;
            if (map.containsKey(prefix)) {
                if (i - map.get(prefix) > 1) {
                    return true;
                }
            } else {
                map.put(prefix, i);
            }
        }
        return false;
    }
}
/*    Time Complexity: O(n)

        Space Complexity: O(min(n, k)) — since remainders are bounded by k values*/
