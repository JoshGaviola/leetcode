class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        
        // Initialize the isPalindrome array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isPalindrome[i][j] = false;
            }
        }
        
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            int minCuts = i;
            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    minCuts = (j == 0) ? 0 : Math.min(minCuts, dp[j - 1] + 1);
                }
            }
            dp[i] = minCuts;
        }
        
        return dp[n - 1];
    }
}
