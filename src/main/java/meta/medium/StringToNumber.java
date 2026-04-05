package meta.medium;

public class StringToNumber {
    public int myAtoi(String s) {
        int index = 0;
        int len = s.length();
        int result = 0;
        int sign = 1;
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }
        if (index < len && s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < len && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        while (index < len && Character.isDigit(s.charAt(index))) {
            int curr = s.charAt(index) - '0';
            if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && curr > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + curr;
            index++;
        }
        return result;
    }
}
// Time complexity :O(n)
// Space Complexity :O(1)