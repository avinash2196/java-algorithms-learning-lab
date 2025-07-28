package meta.hard;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //create set for easier check on wordList
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        //start from begin word and perform BFS using queue to find if end word can be reached from one of path
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
