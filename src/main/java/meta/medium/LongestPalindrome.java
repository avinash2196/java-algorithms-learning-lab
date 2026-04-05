package meta.medium;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] ans = new int[]{0, 0};
        for (int index = 0; index < len; index++) {
            dp[index][index] = true;
        }
        for (int index = 0; index < len - 1; index++) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                dp[index][index + 1] = true;
                ans[0] = index;
                ans[1] = index + 1;
            }
        }
        for (int lenOfSub = 2; lenOfSub < len; lenOfSub++) {
            for (int index = 0; index < len - lenOfSub; index++) {
                int endIndex = index + lenOfSub;
                if (s.charAt(index) == s.charAt(endIndex) && dp[index + 1][endIndex - 1]) {
                    dp[index][endIndex] = true;
                    ans[0] = index;
                    ans[1] = endIndex;
                }
            }
        }
        return s.substring(ans[1] - ans[0] + 1);
    }
}
// Time complexity :O(n^2)
// Space Complexity :O(n^2) --for dp