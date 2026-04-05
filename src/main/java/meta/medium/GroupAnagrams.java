package meta.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams — LeetCode #49 (Medium)
 *
 * <p><b>Problem:</b> Given an array of strings, group all anagrams together.
 *
 * <p><b>Concept:</b> Hash-based grouping using a canonical key. Instead of sorting
 * each string (O(k log k) per string), we build a character-frequency key in O(k),
 * making the overall complexity O(n·k).
 *
 * <p><b>Real-world relevance:</b> Canonical-key grouping appears in data deduplication,
 * search result clustering, and normalizing query representations.
 *
 * <p><b>Design note:</b> The key encodes the 26-letter frequency as {@code #count#}
 * segments to avoid collisions between strings whose raw character sequences differ
 * but whose frequencies match different multi-digit counts.
 *
 * <p>Time: O(n·k) where k = max string length | Space: O(n·k)
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap();
        for (String str : strs) {
            Map<Character, Integer> countMap = new HashMap();
            for (char ch : str.toCharArray()) {
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
            }
            String key = generateKey(countMap);
            ans.computeIfAbsent(key, k -> new ArrayList()).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    private String generateKey(Map<Character, Integer> countMap) {
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append('#').append(countMap.getOrDefault(ch, 0)).append('#');
        } return sb.toString();
    }
}
// Time complexity :O(n*k) --k-->max length of string
// Space Complexity :O(n*k)