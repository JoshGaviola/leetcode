#include <vector>
#include <algorithm>

class Solution {
public:
    int maximalSquare(std::vector<std::vector<char>>& matrix) {
        if (matrix.empty() || matrix[0].empty()) {
            return 0;
        }

        int m = matrix.size();
        int n = matrix[0].size();
        int maxSize = 0;

        // Create a 2D array to store the maximum side length of the square ending at each cell
        std::vector<std::vector<int>> dp(m, std::vector<int>(n, 0));

        // Iterate through the matrix
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    // If it's the first row or column, set dp[i][j] to 1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Calculate the maximum side length of the square ending at (i, j)
                        dp[i][j] = std::min({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]}) + 1;
                    }

                    // Update the maximum side length
                    maxSize = std::max(maxSize, dp[i][j]);
                }
            }
        }

        // Return the area of the largest square
        return maxSize * maxSize;
    }
};
