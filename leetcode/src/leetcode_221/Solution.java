package leetcode_221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp=new int[row][col];
        for (int i = 0; i < col; i++) {    //第一行值转为整型照抄
            dp[0][i]=matrix[0][i]-'0';
        }
        for (int i = 0; i < row; i++) { //第一列值转为整型照抄
            dp[i][0]=matrix[i][0]-'0';
        }

        //动态规划
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;  //新的边长为 三个方向 中值最小的+1
                }else {
                    dp[i][j]=0;
                }

            }
        }
        //返回dp中最大的元素
        int max=0;  //最大边长
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        return max * max;
    }
}