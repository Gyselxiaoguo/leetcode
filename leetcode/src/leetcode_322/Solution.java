package leetcode_322;

class Solution {
    public int coinChange(int[] coins, int amount) {
        //初始化
        int[] dp=new int[amount+1];
        dp[0]=0;
        for (int i = 1; i <amount+1; i++) {
            dp[i]=amount+1;
        }
        //动态规划
        for (int i=0;i<coins.length;i++){
            for (int j = coins[i]; j <=amount; j++) {
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
