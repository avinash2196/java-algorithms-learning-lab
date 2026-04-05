package meta.easy;

public class Strobogrammatic {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        char[] arr = num.toCharArray();
        for (char ch : arr) {
            if (ch == '0' || ch == '8' || ch == '1') {
                sb.append(ch);
            } else if (ch == '6') {
                sb.append('9');
            } else if (ch == '9') {
                sb.append('6');
            } else {
                return false;
            }
        }
        return sb.reverse().toString().equals(num);

    }
}
