package leetcode_48;

class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int i;
        int j;
        int offset=1;
        int startX=0;
        int startY=0;
        int loop=1;
        while(loop<=n/2){
            i = startX;
            j=startY;
            // 遍历当前圈上边每条边元素
            for(j=startY;j<n-offset;j++){
                int k=j-startY;
                // 记录左上角临时值
                int temp = matrix[i][j];
                //左下->左上
                matrix[i][j]=matrix[n-offset-k][startY];
                //右下->左下
                matrix[n-offset-k][startY]=matrix[n-offset][n-offset-k];
                //右上->右下
                matrix[n-offset][n-offset-k]=matrix[startX + k][n-offset];    //
                //左上->左下
                matrix[startX + k][n-offset] = temp;
            }
            loop++;
            offset++;
            startX++;
            startY++;
        }
    }
}