package meta.medium;

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char previousOperator = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Build the number from digits
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }

            // If it's an operator or end of string, process the number and reset
            if ((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == s.length() - 1) {
                switch (previousOperator) {
                    case '+':
                        stack.push(currentNumber);
                        break;
                    case '-':
                        stack.push(-currentNumber);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNumber);
                        break;
                    case '/':
                        stack.push(stack.pop() / currentNumber);
                        break;
                }
                previousOperator = ch;
                currentNumber = 0;
            }
        }

        // Final summation
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

}
// Time complexity : O(n)
// Space Complexity :O(n)