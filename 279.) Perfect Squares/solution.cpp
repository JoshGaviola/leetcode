#include <vector>
#include <cmath>

class Solution {
public:
    int numSquares(int n) {
        // Create a vector to store the minimum number of squares for each number up to n.
        std::vector<int> dp(n + 1, INT_MAX);
        
        // Base case: 0 can be represented by 0 perfect squares.
        dp[0] = 0;
        
        // Iterate from 1 to n to fill in the dp array.
        for (int i = 1; i <= n; ++i) {
            // Try all perfect squares less than or equal to i.
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = std::min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
};
