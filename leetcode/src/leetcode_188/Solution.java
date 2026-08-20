package leetcode_188;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n<=1){
            return 0;
        }

        // [天数][股票状态]
        // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
        int[][] dp=new int[n][2*k+1];   //dp[i][j]：第 i 天结束时，处于状态j的最大利润

        //第一天只能做买入操作，不可能卖出（没股票）.
        for(int j=1;j<2*k;j+=2){
            dp[0][j]=-prices[0];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<2*k-1;j+=2){
                //买入逻辑
                //昨天持有今天不动,昨天空仓今天买入
                dp[i][j+1]=Math.max(dp[i-1][j+1],dp[i-1][j]-prices[i]);
                //卖出逻辑
                //昨天卖出今天不动,昨天持仓今天卖出
                dp[i][j+2]=Math.max(dp[i-1][j+2],dp[i-1][j+1]+prices[i]);
            }
        }
        return dp[n-1][2*k];
    }
}