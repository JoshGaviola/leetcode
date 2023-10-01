class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int n = s.length();
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // Case: "()" at the end of the current substring
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // Case: ")()" pattern within the current substring
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                // Update the maximum length
                maxLen = Math.max(maxLen, dp[i]);
            }
        }

        return maxLen;
    }
}
