package leetcode_57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr=new int[intervals.length+1][];
        System.arraycopy(intervals,0,arr,0,intervals.length);
        arr[intervals.length]=newInterval;

        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int start=arr[0][0];
        int end=arr[0][1];
        List<int[]> list=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            int l=arr[i][0];
            int r=arr[i][1];
            if(l>end){
                list.add(new int[]{start,end});
                start=l;
                end=r;
            }else{
                end=Math.max(end,r);
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);
    }
}