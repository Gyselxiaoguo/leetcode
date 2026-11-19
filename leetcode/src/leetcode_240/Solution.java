package leetcode_240;

/**
 * 从右上角出发
 * 类似于一个‘7’
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int row=0;
        int col=n-1;
        while(row<m&&col>=0){
            if(matrix[row][col]>target){
                col--;
            }else if(matrix[row][col]<target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }
}