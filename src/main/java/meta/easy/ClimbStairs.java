package meta.easy;

/**
 * Climbing Stairs — LeetCode #70 (Easy)
 *
 * <p><b>Problem:</b> You are climbing a staircase with {@code n} steps. Each time you can
 * climb 1 or 2 steps. How many distinct ways can you reach the top?
 *
 * <p><b>Concept:</b> Bottom-up dynamic programming. The number of ways to reach step
 * {@code i} equals the sum of ways to reach {@code i-1} and {@code i-2} — identical
 * recurrence to the Fibonacci sequence.
 *
 * <p><b>Real-world relevance:</b> DP is used in route planning, text segmentation,
 * resource allocation, and many optimization problems. This problem introduces the
 * core idea of building solutions from overlapping subproblems.
 *
 * <p>Time: O(n) | Space: O(n) — can be reduced to O(1) by keeping only two variables.
 */
public class ClimbStairs {

    /**
     * Computes the number of distinct ways to climb {@code n} stairs.
     *
     * <p><b>Design note:</b> We use a {@code dp} array to make the recurrence explicit
     * and easy to follow. An O(1)-space rolling-variable version exists but is slightly
     * less readable for learning purposes.
     *
     * @param n number of stairs (1 ≤ n ≤ 45)
     * @return number of distinct ways to reach the top
     */
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // Time complexity : O (n)
    //Space complexity : O(n)
}
