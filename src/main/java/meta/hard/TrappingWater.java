package meta.hard;

/**
 * Trapping Rain Water — LeetCode #42 (Hard)
 *
 * <p><b>Problem:</b> Given an elevation map represented by an integer array {@code height},
 * compute how much water can be trapped after raining.
 *
 * <p><b>Concept:</b> Two-pointer approach. Water trapped at any position is bounded by
 * {@code min(maxLeft, maxRight) - height[pos]}. By advancing the pointer on the shorter
 * side, we always have a valid bound for the water at that position.
 *
 * <p><b>Why this works:</b> When {@code height[left] < height[right]}, we know the left
 * side is the bottleneck — the right boundary is at least as tall, so
 * {@code leftMax - height[left]} is safe to accumulate.
 *
 * <p><b>Real-world relevance:</b> Histogram/profile processing appears in geographic
 * terrain analysis, image processing, and capacity planning problems.
 *
 * <p>Time: O(n) | Space: O(1)
 */
public class TrappingWater {

    /**
     * Computes the total water units trapped between the elevation bars.
     *
     * @param height elevation map (non-negative integers)
     * @return total water trapped
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
