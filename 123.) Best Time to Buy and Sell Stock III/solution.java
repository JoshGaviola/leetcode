class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE; // The minimum price after the first buy
        int profit1 = 0; // The maximum profit after the first sell
        int buy2 = Integer.MAX_VALUE; // The minimum price after the second buy
        int profit2 = 0; // The maximum profit after the second sell

        for (int price : prices) {
            buy1 = Math.min(buy1, price); // Update the first buy
            profit1 = Math.max(profit1, price - buy1); // Update the first profit
            buy2 = Math.min(buy2, price - profit1); // Update the second buy
            profit2 = Math.max(profit2, price - buy2); // Update the second profit
        }

        return profit2;
    }
}