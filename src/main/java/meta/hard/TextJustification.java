package meta.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int wordIndex = 0;
        while (wordIndex < words.length) {
            int lastWordIndex = wordIndex + 1;
            int count = words[wordIndex].length();
            while (lastWordIndex < words.length) if ((count + words[lastWordIndex].length() + 1) > maxWidth) {
                break;
            } else {
                count += words[lastWordIndex].length() + 1;
                lastWordIndex++;
            }
            int gaps = lastWordIndex - wordIndex - 1;
            StringBuilder line = new StringBuilder();
            if (lastWordIndex == words.length || gaps == 0) {
                for (int i = wordIndex; i < lastWordIndex; i++) {
                    line.append(words[i]).append(" ");
                }
                line.setLength(line.length() - 1);
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int totalSpacesLeft = maxWidth - count + gaps;
                int spacesPerGap = totalSpacesLeft / gaps;
                int extra = totalSpacesLeft % gaps;
                for (int i = 0; i < lastWordIndex - 1; i++) {
                    line.append(words[i]).append(" ");
                    line.append(" ".repeat(spacesPerGap + (i - wordIndex) > extra ? 1 : 0));
                }
                line.append(words[lastWordIndex - 1]);
            }
            result.add(line.toString());
            wordIndex = lastWordIndex;
        }
        return result;
    }
}
