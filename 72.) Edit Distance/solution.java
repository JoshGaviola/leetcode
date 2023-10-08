class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a DP table where dp[i][j] represents the minimum edits to convert word1[0..i-1] to word2[0..j-1].
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the DP table.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // Insert j characters to match word2.
                } else if (j == 0) {
                    dp[i][j] = i; // Delete i characters to match word2.
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation needed.
                } else {
                    // Find the minimum of insert, delete, and replace operations.
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }
}
