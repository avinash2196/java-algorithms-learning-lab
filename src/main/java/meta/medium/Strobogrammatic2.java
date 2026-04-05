package meta.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strobogrammatic2 {

    private static final char[][] PAIRS = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public List<String> findStrobogrammatic(int n) {
        return buildStrobogrammatic(n, n);
    }

    private List<String> buildStrobogrammatic(int n, int totalLength) {
        // Base case: even-length center
        if (n == 0) return new ArrayList<>(List.of(""));
        // Base case: odd-length center
        if (n == 1) return new ArrayList<>(List.of("0", "1", "8"));

        List<String> middles = buildStrobogrammatic(n - 2, totalLength);
        List<String> result = new ArrayList<>();

        for (String middle : middles) {
            for (char[] pair : PAIRS) {
                // Avoid numbers that start with 0, unless length is 1
                if (n != totalLength || pair[0] != '0') {
                    result.add(pair[0] + middle + pair[1]);
                }
            }
        }

        return result;
    }
}
/*    Time Complexity: O(5^(n/2))

        Each layer generates up to 5 combinations (number of valid pairs).

        Space Complexity:

        O(n) recursion stack

        O(5^(n/2)) output size*/

