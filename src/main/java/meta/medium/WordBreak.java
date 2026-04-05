package meta.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break — LeetCode #139 (Medium)
 *
 * <p><b>Problem:</b> Given a string {@code s} and a dictionary of words, determine
 * whether {@code s} can be segmented into a space-separated sequence of dictionary words.
 *
 * <p><b>Concept:</b> 1-D bottom-up dynamic programming.
 * {@code dp[i]} = true means the substring {@code s[0..i-1]} can be fully segmented.
 * We build up from {@code dp[0] = true} (empty prefix is trivially segmentable).
 *
 * <p><b>Real-world relevance:</b> String segmentation is used in NLP tokenization,
 * search query parsing, and input validation in type-ahead systems.
 *
 * <p><b>Design note:</b> Converting the word list to a {@code HashSet} gives O(1)
 * average-case lookup per substring check, bringing total time to O(n²) rather
 * than O(n² · m) where m = dictionary size.
 *
 * <p>Time: O(n²) | Space: O(n)
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
// Time complexity :O(N^2)
// Space Complexity :O(N)