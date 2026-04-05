package meta.hard;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        //create map for t for frequency
        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tFreq.put(ch, tFreq.getOrDefault(ch, 0) + 1);
        }
        int matchRequired = tFreq.size();
        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int currMatch = 0;
        int len = s.length();
        // iterate over s and keep on building map for s

        for (int right = 0; right < len; right++) {
            char r = s.charAt(right);
            sFreq.put(r, sFreq.getOrDefault(r, 0 + 1));
            if (tFreq.containsKey(r) && tFreq.get(r).intValue() == sFreq.get(r).intValue()) {
                currMatch++;
            }
            //if t contains current char and it has same count updated matched
            while (currMatch == matchRequired) {
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    start = left;
                }
                //while matched == size of t map , find and and then try to contract window size
                char l = s.charAt(left++);
                sFreq.put(l, sFreq.get(l) - 1);
                if (tFreq.containsKey(l) && sFreq.get(l) < tFreq.get(l)) {
                    currMatch--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
