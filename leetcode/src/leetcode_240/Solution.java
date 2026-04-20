package leetcode_240;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow=0;
        int startCol=matrix[0].length-1;
        while (startCol>=0 && startRow<matrix.length){
            int rightTop=matrix[startRow][startCol];
            if(target<rightTop){
                startCol--;
            } else if (target>rightTop) {
                startRow++;
            }else {
                return true;
            }
        }
        return false;
    }
}