package meta.medium.MonotonicStack;

import java.util.Stack;

public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        //simply add heights in stack and keep on checking if new height >=height in stack ,pop as it wont have ocean view
        Stack<Integer> stack = new Stack<>();
        for (int index = heights.length - 1; index >= 0; index--) {
            if (stack.isEmpty() || heights[stack.peek()] < heights[index]) {
                stack.push(index);
            }
        }
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }
        return result;
    }
}
        /*Time and Space Complexity:
        Time	Space
        O(n)	O(n)
       */