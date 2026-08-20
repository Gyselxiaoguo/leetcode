package leetcode_452;

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
//        Arrays.sort(points, (o1, o2)->o1[1]-o2[1]);   //利用差值正负判断大小,存在整数溢出风险
        //对每个区间的右边界进行升序排序
        Arrays.sort(points, (o1, o2)->Integer.compare(o1[1],o2[1]));//只做大小比较，不做减法，彻底规避溢出

        int axis=points[0][1];  //第一个区间的右边界
        int count=1;
        for (int i = 1; i < points.length; i++) {
            int left=points[i][0];
            int right=points[i][1];
            if(left>axis){  //无交集，使用到的箭数+1
                count++;
                axis=right;
            }
        }
        return count;
    }
}