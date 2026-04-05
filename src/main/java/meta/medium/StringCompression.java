package meta.medium;

public class StringCompression {
    public int compress(char[] chars) {
        int write = 0;  // Pointer to write the result
        int read = 0;   // Pointer to read through the array

        while (read < chars.length) {
            char currentChar = chars[read];
            int start = read;

            // Move read pointer to the end of the current group
            while (read < chars.length && chars[read] == currentChar) {
                read++;
            }

            int count = read - start;
            chars[write++] = currentChar;

            if (count > 1) {
                // Convert count to string and write each digit
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
 /*Time & Space Complexity:
         Time: O(n)

         Space: O(1) — no extra space except a few variables*/