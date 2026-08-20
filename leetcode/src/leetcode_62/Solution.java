package leetcode_62;

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];   //没有使用0行0列
        Arrays.fill(dp[1],1);   //第一行填充为1
        for(int i=1;i<=m;i++){  //第一列填充为1
            dp[i][1]=1;
        }
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}