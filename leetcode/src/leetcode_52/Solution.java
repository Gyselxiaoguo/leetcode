package leetcode_52;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int totalNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        int[][] arr=new int[n][n];
        findPos(arr,0,result);
        return result.size();
    }

    private void findPos(int[][] arr, int y, List<List<String>> result) {
        if(y==arr.length){
            List<String> sol=new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < arr.length; j++) {
                    if(arr[i][j]==1){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                sol.add(sb.toString());
            }
            result.add(sol);
            return;
        }

        for (int x = 0; x < arr.length; x++) {
            if(canUse(arr,x,y)){
                arr[x][y]=1;
                findPos(arr,y+1,result);
                arr[x][y]=0;
            }
        }

    }

    private boolean canUse(int[][] arr, int x, int y) {
        for (int i = 0; i < y; i++) {
            if(arr[x][i]==1){
                return false;
            }
        }

        int x1=x;
        int y1=y;
        while (x1<arr.length-1&&y1>0){
            if(arr[++x1][--y1]==1){
                return false;
            }
        }

        int x2=x;
        int y2=y;
        while (x2>0&&y2>0){
            if(arr[--x2][--y2]==1){
                return false;
            }
        }

        return true;
    }

}