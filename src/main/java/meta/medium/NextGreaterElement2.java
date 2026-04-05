package meta.medium;

import java.util.*;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        // Traverse the array twice to simulate circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;

            // Maintain decreasing stack (monotonic stack)
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[index]) {
                stack.pop();
            }

            result[index] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(index);
        }

        return result;
    }
}
