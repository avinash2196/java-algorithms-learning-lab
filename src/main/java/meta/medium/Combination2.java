package meta.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        backTrack(candidates, target, result, new LinkedList(), 0);
        return result;
    }

    private void backTrack(int[] candidates, int remain, List<List<Integer>> result, LinkedList<Integer> currList, int startIndex) {
        if (remain == 0) {
            result.add(new ArrayList(currList));
            return;
        } else {
            for (int i = startIndex; i < candidates.length; i++) {
                if (i > startIndex && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                if (candidates[i] > remain) break;
                currList.add(candidates[i]);
                backTrack(candidates, remain - candidates[i], result, currList, i + 1);
                currList.removeLast();
            }
        }
    }
}
// Time complexity :O(2 ^ n)
// Space Complexity :O(n*k) number of valid combos
