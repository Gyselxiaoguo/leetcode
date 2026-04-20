package leetcode_200;

class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    //没被访问过
                    count++;
                    traverse(grid,i,j);
                }
            }
        }
        return count;
    }
    private void traverse(char[][] grid,int i,int j){
        if(i<0||i>= grid.length||j<0||j>=grid[0].length||grid[i][j]=='2')return;
        if(grid[i][j]=='1'){
            grid[i][j]='2';//访问过 标记
            //检查 上、下、左、右 是否岛屿
            traverse(grid,i-1,j);//左
            traverse(grid,i,j-1);//上
            traverse(grid,i+1,j);//右
            traverse(grid,i,j+1);//下
        }
    }

}