package leetcode_452;

import java.util.Arrays;

/**
 * 射气球，按右边界升序排序
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
//        Arrays.sort(points, (o1, o2)->o1[1]-o2[1]);   //利用差值正负判断大小,存在整数溢出风险
        //对每个区间的右边界进行升序排序
        Arrays.sort(points, (o1, o2)->Integer.compare(o1[1],o2[1]));//只做大小比较，不做减法，彻底规避溢出

        int start=points[0][0];
        int end=points[0][1];
        int count=1;
        for (int i = 1; i < points.length; i++) {
            int left=points[i][0];
            int right=points[i][1];
            if(left>end){
                count++;
                start=left;
                end=right;
            }else{
                start=Math.max(start,left);
                end=Math.min(end,right);
            }
        }
        return count;
    }
}