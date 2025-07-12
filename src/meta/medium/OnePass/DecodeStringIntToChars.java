package meta.medium.OnePass;

public class DecodeStringIntToChars {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int index = 2; index <= s.length(); index++) {
            int oneDigit = Integer.parseInt(s.substring(index - 1, index));
            int twoDigits = Integer.parseInt(s.substring(index - 2, index));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[index] = dp[index - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[index] = dp[index - 2];
            }
        }
        return dp[s.length()];
    }
/*    Time & Space Complexity:
    Time: O(n)

    Space: O(n)*/
}
