package meta.hard;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDistinctSubStrings {
    private Map<int[], Integer> memo = new HashMap<>();

    public int numDistinct(String s, String t) {
        //find recursively count of valid substring
        return recurse(s, t, 0, 0);
    }

    private int recurse(String s, String t, int sIndex, int tIndex) {
        //validate if we need to go further by checking if we reached end of strings or if valid iterations left
        if (s.length() == sIndex || t.length() == tIndex || s.length() - sIndex < t.length() - tIndex) {
            return tIndex == t.length() ? 1 : 0;
        }
        int[] key = new int[]{sIndex, tIndex};
        if (memo.containsKey(key)) return memo.get(key);
//        either use this or move ahead without current
        int ans = recurse(s, t, sIndex + 1, tIndex);
        if (s.charAt(sIndex) == t.charAt(tIndex)) ans += recurse(s, t, sIndex + 1, tIndex + 1);
        memo.put(key, ans);
        return ans;
    }

}
