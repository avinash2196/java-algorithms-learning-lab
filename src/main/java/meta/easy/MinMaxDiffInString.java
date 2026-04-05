package meta.easy;

public class MinMaxDiffInString {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int pos = 0;
        int len = s.length() - 1;
        String minNum = s;
        String maxNum = s;
        while (pos <= len && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos <= len) {
            maxNum = s.replace(s.charAt(pos), '9');
        }
        minNum = minNum.replace(minNum.charAt(0), '0');
        return Integer.parseInt(maxNum) - Integer.parseInt(minNum);
    }
}
// Time complexity :O(n)
// Space Complexity :O(n)
