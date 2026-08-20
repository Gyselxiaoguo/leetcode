package leetcode_54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int loop=1;
        int offset=1;
        int i=0;
        int j=0;
        int m=matrix.length;    //行
        int n=matrix[0].length; //列
        int startX=0;
        int startY=0;
        List<Integer> res=new ArrayList<>();
        while(loop<=Math.min(m,n)/2){
            i=startX;
            j=startY;
            for(j=startY;j<n-offset;j++){
                res.add(matrix[i][j]);
            }
            for(i=startX;i<m-offset;i++){
                res.add(matrix[i][j]);
            }
            for(j=n-offset;j>startY;j--){
                res.add(matrix[i][j]);
            }
            for(i=m-offset;i>startX;i--){
                res.add(matrix[i][j]);
            }
            loop++;
            startX++;
            startY++;
            offset++;
        }
        //处理奇数情况
        i=startX;
        j=startY;
        if(Math.min(m,n)%2==1){
            if(m<n){
                for(j=startY;j<=n-offset;j++){  //取所有元素=
                    res.add(matrix[i][j]);
                }
            }else if(m>n){
                for(i=startX;i<=m-offset;i++){
                    res.add(matrix[i][j]);
                }
            }else{
                res.add(matrix[i][j]);
            }
        }
        return res;
    }
}