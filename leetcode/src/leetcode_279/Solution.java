package leetcode_279;

class Solution {
    /**
     * 动态规划解决 0-1 背包问题
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=n+1;
        }
        for(int i=1;i*i<=n;i++){
            for(int j=i*i;j<=n;j++){
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}