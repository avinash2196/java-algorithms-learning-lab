package meta.medium;

public class ZizagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        int currRow = 0;
        boolean goingDown = false;
        for (char ch : s.toCharArray()) {
            rows[currRow].append(ch);
            if (currRow == 0 || currRow == numRows - 1) goingDown = !goingDown;
            currRow += goingDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder curr : rows) {
            sb.append(curr);
        }
        return sb.toString();
    }
}
/*
            Time & Space Complexity:
            Time: O(m × n) → Scans every cell once

            Space: O(1) → No extra data structures*/