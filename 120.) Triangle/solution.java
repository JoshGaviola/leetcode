class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Initialize a DP array to store the minimum path sum for each element in the triangle.
        int[] dp = new int[n];

        // Initialize the DP array with the last row of the triangle.
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Start from the second-to-last row and update the DP array.
        for (int row = n - 2; row >= 0; row--) {
            for (int i = 0; i <= row; i++) {
                // Update the DP array with the minimum of the two adjacent elements from the row below.
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(row).get(i);
            }
        }

        // The final result is stored in dp[0], which represents the minimum path sum from top to bottom.
        return dp[0];
    }
}
