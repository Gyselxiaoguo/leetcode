package leetcode_73;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        Set<Integer> setX=new HashSet<>();  //记录带有0的行
        Set<Integer> setY=new HashSet<>();  //记录带有0的列
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    setX.add(i);
                    setY.add(j);
                }
            }
        }
        //填充0
        for (int r : setX) {
            Arrays.fill(matrix[r], 0);
        }
        for (int c : setY) {
            for (int i = 0; i < row; i++) {
                matrix[i][c] = 0;
            }
        }
        
    }
}