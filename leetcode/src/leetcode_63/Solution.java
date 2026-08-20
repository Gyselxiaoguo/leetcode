package leetcode_63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 起点就是障碍物，直接0
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];

        dp[0][0]=1;
        for(int i=1;i<n;i++){   //初始化第0行
            dp[0][i]=obstacleGrid[0][i]==0?dp[0][i-1]:0;
        }
        for(int j=1;j<m;j++){   //初始化第0列
            dp[j][0]=obstacleGrid[j][0]==0?dp[j-1][0]:0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
