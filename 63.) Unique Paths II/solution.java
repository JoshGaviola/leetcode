class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Create a 2D array to store the number of unique paths at each cell.
        int[][] dp = new int[m][n];

        // Initialize the top row and left column based on obstacles.
        boolean obstacleFound = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleFound = true;
            }
            dp[i][0] = obstacleFound ? 0 : 1;
        }
        obstacleFound = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                obstacleFound = true;
            }
            dp[0][j] = obstacleFound ? 0 : 1;
        }

        // Calculate the number of unique paths for each cell using dynamic programming.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // If there's an obstacle, no paths are possible.
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // The value at dp[m - 1][n - 1] represents the number of unique paths to the bottom-right corner.
        return dp[m - 1][n - 1];
    }
}
