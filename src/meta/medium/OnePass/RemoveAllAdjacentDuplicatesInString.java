package meta.medium.OnePass;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int sbIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sbIndex != 0 && s.charAt(i) == sb.charAt(sbIndex - 1)) {
                sb.deleteCharAt(sbIndex - 1);
                sbIndex--;
            } else {
                sb.append(s.charAt(i));
                sbIndex++;
            }

        }
        return sb.toString();
    }
}
