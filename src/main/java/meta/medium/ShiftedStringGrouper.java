package meta.medium;

import java.util.*;

public class ShiftedStringGrouper {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> grouped = new HashMap<>();

        for (String str : strings) {
            String key = getShiftKey(str);
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(grouped.values());
    }

    // Generate a normalized key for the shift pattern
    private String getShiftKey(String str) {
        if (str.length() == 1) return "single";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            // Difference modulo 26 to wrap around the alphabet
            int diff = (str.charAt(i) - str.charAt(i - 1) + 26) % 26;
            sb.append(diff).append(",");
        }
        return sb.toString();
    }
}
/*
    Time Complexity: O(n * k) where:

    n = number of strings

    k = max length of a string (for key generation)

    Space Complexity: O(n * k) for the map and result
*/
