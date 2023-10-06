class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of unique paths at each cell.
        int[][] dp = new int[m][n];

        // Initialize the top row and left column to 1 since there's only one way to reach them.
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Calculate the number of unique paths for each cell using dynamic programming.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The value at dp[m - 1][n - 1] represents the number of unique paths to the bottom-right corner.
        return dp[m - 1][n - 1];
    }
}
