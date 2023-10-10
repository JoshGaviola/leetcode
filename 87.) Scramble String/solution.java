public boolean isScramble(String s1, String s2) {
    int n = s1.length();
    if (n != s2.length()) {
        return false;
    }
    
    // Create a 3D DP array dp[i][j][k] where i and j are the starting indices
    // of s1 and s2, and k is the length of the substring.
    boolean[][][] dp = new boolean[n][n][n + 1];
    
    // Initialize the DP array for substrings of length 1.
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
        }
    }
    
    // Fill the DP array for substrings of length >= 2.
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            for (int j = 0; j <= n - len; j++) {
                for (int k = 1; k < len; k++) {
                    boolean scramble1 = dp[i][j][k] && dp[i + k][j + k][len - k];
                    boolean scramble2 = dp[i][j + len - k][k] && dp[i + k][j][len - k];
                    if (scramble1 || scramble2) {
                        dp[i][j][len] = true;
                        break;
                    }
                }
            }
        }
    }
    
    return dp[0][0][n];
}
