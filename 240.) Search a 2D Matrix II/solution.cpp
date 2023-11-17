#include <vector>

class Solution {
public:
    bool searchMatrix(std::vector<std::vector<int>>& matrix, int target) {
        if (matrix.empty() || matrix[0].empty()) {
            return false;
        }

        int m = matrix.size();
        int n = matrix[0].size();

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Target found
            } else if (matrix[row][col] < target) {
                // Move to the next row (down) as the current element is smaller than the target
                row++;
            } else {
                // Move to the previous column (left) as the current element is larger than the target
                col--;
            }
        }

        return false; // Target not found
    }
};
