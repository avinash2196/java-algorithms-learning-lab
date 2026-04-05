package meta.hard;

import java.util.*;

/**
 * Word Ladder — LeetCode #127 (Hard)
 *
 * <p><b>Problem:</b> Find the shortest transformation sequence from {@code beginWord}
 * to {@code endWord}, changing one letter at a time, where each intermediate word must
 * exist in the given word list. Return the length of the shortest sequence, or 0 if
 * none exists.
 *
 * <p><b>Concept:</b> BFS on an implicit graph. Each word is a node; an edge exists
 * between two words that differ by exactly one character. BFS guarantees the shortest
 * path is found first.
 *
 * <p><b>Real-world relevance:</b> Shortest-path BFS on implicit graphs is used in
 * spell checkers, network routing, gene mutation analysis, and puzzle solvers.
 *
 * <p>Time: O(n · k · 26) where n = word list size, k = word length | Space: O(n · k)
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //create set for easier check on wordList
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        //start from begin word and perform BFS using queue to find if endword can be reached from one of path
        queue.offer(beginWord);
        set.remove(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int index = 0; index < size; index++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) return level;
                List<String> neighbors = getNeighbors(currWord, set);
                for (String neighbor : neighbors) {
                    queue.offer(neighbor);
                    set.remove(neighbor);
                }
            }
        }
        return 0;
    }

    private List<String> getNeighbors(String currWord, Set<String> set) {
        //find all valid paths from a to z and keep on checking if they are valid
        //start from first digit
        List<String> neighbors = new ArrayList<>();
        char[] charList = currWord.toCharArray();
        for (int i = 0; i < charList.length; i++) {
            char ch = charList[i];
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;
                if (c == ch || !set.contains(String.valueOf(charList))) {
                    continue;
                }
                neighbors.add(String.valueOf(charList));

            }
            charList[i] = ch;
        }
        return neighbors;
    }
}
