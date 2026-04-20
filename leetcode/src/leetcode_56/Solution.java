package leetcode_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        int[] arr = new int[5];
        int[] arr2={1,2,3,4,5};
        int[] arr3 = new int[]{1, 2, 3, 4, 5};


        int len=intervals.length;
        //根据左边界值进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int left=intervals[i][0];
            int right=intervals[i][1];
            //无交集
            if(list.size()==0 || left>list.get(list.size()-1)[1]){
                list.add(new int[]{left,right});
            }
            //有交集
            if(left<=list.get(list.size()-1)[1] || right<=list.get(list.size()-1)[1]){
                list.get(list.size()-1)[1]=Math.max(right,list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}


