package meta.hard;

public class ValidNumber {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponential = false;
        boolean seenDot = false;
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                seenDigit = true;
            } else if (ch == '+' || ch == '-') {
                if (index > 0 && s.charAt(index - 1) != 'e' && s.charAt(index - 1) != 'E') {
                    return false;
                }
            } else if (ch == 'e' || ch == 'E') {
                if (seenExponential || !seenDigit) {
                    return false;
                }
                seenExponential = true;
                seenDigit = false;
            } else if (ch == '.') {
                if (seenDot || seenExponential) {
                    return false;
                }
                seenDot = true;
            }
        }
        return seenDigit;
    }
}
