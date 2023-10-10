public int numTrees(int n) {
    // Create an array to store the number of unique BSTs for each number of nodes from 0 to n.
    int[] dp = new int[n + 1];

    // There is 1 unique BST for 0 nodes (empty tree).
    dp[0] = 1;

    // Calculate the number of unique BSTs for each number of nodes from 1 to n.
    for (int nodes = 1; nodes <= n; nodes++) {
        for (int root = 1; root <= nodes; root++) {
            // The number of unique BSTs for a given number of nodes
            // is the sum of BSTs with each number as the root node.
            dp[nodes] += dp[root - 1] * dp[nodes - root];
        }
    }

    return dp[n];
}
