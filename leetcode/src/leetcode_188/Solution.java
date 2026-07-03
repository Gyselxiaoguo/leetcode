package leetcode_188;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        // [天数][股票状态]
        // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
        int n = prices.length;
        int[][] dp = new int[n][k*2 + 1];   //dp [i][s]：第 i 天结束后，状态 s 的最大利润

        /**
         * 第 0 天（第一天）只能做买入操作
         * dp [0][1] = -prices [0]：第一天第一次买入持仓
         * dp [0][3] = -prices [0]：第一天假装第二次买入（等效当天先卖再买，利润不变）
         */
        for (int i = 1; i < k*2; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k*2 - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);//max(前一天同持仓, 前一天j空仓 - 今日股价)
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);//max(前一天同空仓, 前一天j+1持仓 + 今日股价).

            }
        }
        return dp[n - 1][k*2];
    }
}