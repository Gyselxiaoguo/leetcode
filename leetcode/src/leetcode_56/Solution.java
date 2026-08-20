package leetcode_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));//按照左区间升序排序
        int axis1=intervals[0][0];
        int axis2=intervals[0][1];
        List<int[]> list=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            int left=intervals[i][0];
            int right=intervals[i][1];

            if(left<=axis2){
                axis2=Math.max(right,axis2);    //有区间取最大
            }else{
                list.add(new int[]{axis1,axis2});
                axis1=left;
                axis2=right;
            }
        }
        list.add(new int[]{axis1,axis2});
        return list.toArray(new int[list.size()][]);
    }
}


