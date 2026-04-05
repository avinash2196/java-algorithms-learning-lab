package meta.medium;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList());
        for (int num : nums) {
            List<List<Integer>> currList = new ArrayList();
            for (List<Integer> curr : result) {
                List<Integer> list = new ArrayList<>(curr);
                list.add(num);
                currList.add(list);
            }
            for (List<Integer> curr : currList) {
                result.add(curr);
            }
        }
        return result;
    }
}
// Time complexity :O(k * 2^n)
// Space Complexity :O(n* 2^n)