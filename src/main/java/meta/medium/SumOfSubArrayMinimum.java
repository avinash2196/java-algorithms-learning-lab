package meta.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubArrayMinimum {
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            int MOD = 1_000_000_007;

            int[] prevLess = new int[n];
            int[] nextLess = new int[n];

            // Monotonic increasing stack for previous less
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                prevLess[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
                stack.push(i);
            }

            // Clear stack for next pass
            stack.clear();

            // Monotonic increasing stack for next less
            for (int i = n - 1; i >= 0; --i) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                nextLess[i] = stack.isEmpty() ? n - i : stack.peek() - i;
                stack.push(i);
            }

            long result = 0;
            for (int i = 0; i < n; ++i) {
                result = (result + (long) arr[i] * prevLess[i] * nextLess[i]) % MOD;
            }

            return (int) result;
        }
    }

}
