package meta.medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSub {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int startIndex = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap();
        for (int endIndex = 0; endIndex < len; endIndex++) {
            if (map.containsKey(s.charAt(endIndex))) {
                startIndex = Math.max(startIndex, map.get(s.charAt(endIndex)) + 1);
            }
            maxLen = Math.max(maxLen, endIndex - startIndex + 1);
            map.put(s.charAt(endIndex), endIndex);
        }
        return maxLen;
    }
}
// Time complexity :O(n)
// Space Complexity :O(min(m,n)) m - len of ASCII char set