package leetcode_279;

import java.util.Arrays;

class Solution {
    /**
     * 动态规划解决 0-1 背包问题
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp=new int[n+1];  //数字i 最少由多少个完全平方数相加得到
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for(int i=1;i*i<=n;i++){    //i ~ 1,4,9,...
            for(int j=i*i;j<=n;j++){
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}

/**
 * 二维数组解法
 * class Solution {
 *     public int numSquares(int n) {
 *         List<Integer> list=new ArrayList<>();
 *         int k=1;
 *         while(k*k<=n){
 *             list.add(k*k);
 *             k++;
 *         }
 *         int[][] dp=new int[list.size()][n+1];
 *         for(int j=0;j<=n;j++){
 *             dp[0][j]=j;
 *         }
 *         for(int i=1;i<list.size();i++){
 *             for(int j=1;j<=n;j++){
 *                 if(j<list.get(i)){
 *                     dp[i][j]=dp[i-1][j];
 *                 }else{
 *                     dp[i][j]=Math.min(dp[i-1][j],dp[i][j-list.get(i)]+1);    //可重选，自己举例写式子
 *                 }
 *             }
 *         }
 *         return dp[list.size()-1][n];
 *     }
 * }
 */
