package leetcode_63;

class Solution {
    /**
     * 与62题相似，只是处理了下障碍的影响
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {   //将有障碍的位置设为0，其他为1
            for (int j = 0; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
            }
        }

        /**
         * 上边界中，有障碍的位置以及右边位置全置为0
         * 左边界中，有障碍的位置以及下边位置全置为0
         */
        for (int i = 0; i < n; i++) {
            if(dp[0][i]==0){
                for (int k = i; k < n; k++) {
                    dp[0][k] = 0;
                }
                break; // 后面全0，无需继续循环
            }
        }
        for (int i = 0; i < m; i++) {
            if(dp[i][0]==0){
                for (int k = i; k < m; k++) {
                    dp[k][0] = 0;
                }
                break; // 后面全0，无需继续循环
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(dp[i][j]==0){
                    continue;
                }else {
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
