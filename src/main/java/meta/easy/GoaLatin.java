package meta.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoaLatin {
    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String[] tokens = sentence.split(" ");
        for (int index = 0; index < tokens.length; index++) {
            String word = tokens[index];
            StringBuilder curr = new StringBuilder();
            if (vowels.contains(word.charAt(0))) {
                curr.append(word);
            } else {
                curr.append(word.substring(1));
                curr.append(word.charAt(0));
            }
            curr.append("ma");
            curr.append("a".repeat(index + 1));

            result.append(curr);
            if (index != tokens.length - 1) result.append(" ");
        }
        return result.toString();
    }
    // Time complexity :O(n)
    // Space Complexity :O(n)

  /*  If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
    For example, the word "apple" becomes "applema".
    If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".
    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
    Return the final sentence representing the conversion from sentence to Goat Latin.*/
}
