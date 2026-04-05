package meta.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination1 {
    private int n;
    private int k;
    private List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        backTrack(new LinkedList(), 1);
        return result;
    }

    private void backTrack(LinkedList<Integer> currList, int currIndex) {
        if (currList.size() == k) {
            result.add(new ArrayList<>(currList));
            return;
        }
        for (int i = currIndex; i <= (n - (k - currList.size())) + 1; i++) {
            currList.add(i);
            backTrack(currList, i + 1);
            currList.removeLast();
        }
    }
}
// Time complexity :O(k * C(n,k))
// Space Complexity :O(k+C(n,k))