package leetcode_51;

import java.util.ArrayList;
import java.util.List;

class Solution {

    /*
    * 按列尝试放置皇后，可以放置皇后的位置在map中标记为1
    * */
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        int[][] arr=new int[n][n];  //1->Q  0->.
        findPos(arr,0);
        return result;
    }

    private void findPos(int[][] arr, int y) {
        if(y== arr.length){ //终止条件，这是将 1->Q  0->.
            List<String> path=new ArrayList<>();
            for (int[] ints : arr) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    if(ints[i]==0){
                        sb.append(".");
                    }else {
                        sb.append("Q");
                    }
                }
                path.add(sb.toString());
            }
            result.add(path);
            return;
        }

        for (int x = 0; x < arr.length; x++) {
            if(canUse(arr,x,y)){
                arr[x][y]=1;
                findPos(arr,y+1);
                arr[x][y]=0;
            }
        }
    }

    //判断是否可以放皇后
    public boolean canUse(int[][] arr,int x,int y){
        //同一行
        for (int i = 0; i < y; i++) {
            if(arr[x][i]==1){
                return false;
            }
        }
        //对角线
        int x1=x;
        int y1=y;
        while (x1>0&&y1>0){ //辅对角线有没有皇后
            if(arr[--x1][--y1]==1){
                return false;
            }
        }
        int x2=x;
        int y2=y;
        while (x2<arr.length-1&&y2>0){ //主对角线有没有皇后
            if(arr[++x2][--y2]==1){
                return false;
            }
        }
        return true;
    }
}