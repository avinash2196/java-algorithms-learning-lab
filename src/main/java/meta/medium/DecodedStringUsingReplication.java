package meta.medium;

import java.util.Stack;

public class DecodedStringUsingReplication {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(currentNum);
                strStack.push(currentString);
                currentNum = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                int repeatCount = countStack.pop();
                StringBuilder previousString = strStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    previousString.append(currentString);
                }
                currentString = previousString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}


/*
    Time Complexity: O(n)
        Each character is visited once; string appends are amortized linear due to use of StringBuilder.

        Space Complexity: O(n)
        Due to the use of stacks and temporary strings.*/
