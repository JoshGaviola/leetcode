#include <vector>
#include <algorithm>

class Solution {
public:
    int maxProfit(int k, std::vector<int>& prices) {
        int n = prices.size();
        if (n <= 1 || k == 0) return 0;

        if (k >= n / 2) {
            // If k is large enough, we can perform unlimited transactions, similar to the best-time-to-buy-and-sell-stock-II problem.
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        std::vector<std::vector<int>> buy(n, std::vector<int>(k + 1, 0));
        std::vector<std::vector<int>> sell(n, std::vector<int>(k + 1, 0));

        for (int i = 1; i <= k; i++) {
            buy[0][i] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            buy[i][0] = std::max(buy[i - 1][0], -prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = std::max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i]);
                sell[i][j] = std::max(sell[i - 1][j], buy[i - 1][j] + prices[i]);
            }
        }

        return sell[n - 1][k];
    }
};
