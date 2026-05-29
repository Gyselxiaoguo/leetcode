package leetcode_279;

class Solution {
    /**
     * 动态规划解决 0-1 背包问题
     * @param n
     * @return
     */
    public int numSquares(int n) {
        //数组的初始化
        int[] dp = new int[n+1];
        dp[0]=0;
        for (int i = 1; i <= n; i++) {
            dp[i]=n+1;
        }
        //正式开始
        for(int num=1;num*num<=n;num++){
            int square=num*num;
            for (int j = square; j<=n; j++) {
                dp[j]=Math.min(dp[j],dp[j-square]+1);
            }
        }
        return dp[n];
    }
}