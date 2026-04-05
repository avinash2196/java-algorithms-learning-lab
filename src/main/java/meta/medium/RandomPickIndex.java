package meta.medium;

import java.util.*;

public class RandomPickIndex {

    private Map<Integer, List<Integer>> indexMap;
    private Random random;

    // Constructor: preprocess to map each number to all its indices
    public RandomPickIndex(int[] nums) {
        indexMap = new HashMap<>();
        random = new Random();

        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    // Picks a random index for the target value with equal probability
    public int pick(int target) {
        List<Integer> indices = indexMap.get(target);
        return indices.get(random.nextInt(indices.size()));
    }
}
/*      Time and Space Complexity
        Operation	Time	Space
        Constructor	O(n)	O(n) — stores indices
        pick()	O(1)	O(1)        */