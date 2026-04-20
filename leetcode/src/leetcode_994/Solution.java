package leetcode_994;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    //四个方向的偏移量
    private static final int[][] DIRECTION={{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        //队列存储腐烂橘子的坐标和时间
        Queue<int[]> queue=new ArrayDeque<>();
        // 统计新鲜橘子的数量
        int freshCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j,0});
                }else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        int maxTime=0;
        //没有新鲜橘子
        if(freshCount==0)return 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x=curr[0];
            int y=curr[1];
            int time=curr[2];
            //更新最大时间
            maxTime = Math.max(time, maxTime);
            //尝试感染邻居
            for (int[] dir : DIRECTION) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                //邻居是新鲜橘子
                if(xx>=0&&xx<row&&yy>=0&&yy<col&&grid[xx][yy]==1){
                    grid[xx][yy]=2;//感染
                    freshCount--;
                    queue.add(new int[]{xx,yy,time+1});
                }
            }
        }
        return freshCount==0?maxTime:-1;
    }
}