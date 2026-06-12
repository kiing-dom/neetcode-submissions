class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int buy = 0;
        int maxProfit = Integer.MIN_VALUE;
        for (int sell = 1; sell < prices.length; sell++) {
            if (prices[buy] > prices[sell]) {
                buy = sell;
            }

            maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
        }

        return maxProfit;
    }
}