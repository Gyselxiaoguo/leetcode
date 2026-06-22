package leetcode_57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*将这个一维数组放入二维数组中，这个问题56题的合并区间一样了*/
        int[][] arr=new int[intervals.length+1][];  //二维数组的行数确定
        System.arraycopy(intervals,0,arr,0,intervals.length);
        arr[intervals.length]=newInterval;

        //1.按每个区间的左边界进行升序排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //2.
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int left=arr[i][0]; //区间最小值
            int right=arr[i][1];    //区间最大值
            if(list.isEmpty() ||left>list.get(list.size()-1)[1]){    //没有交集
                list.add(new int[]{left,right});
            }
            if(left<=list.get(list.size()-1)[1]||right<=list.get(list.size()-1)[1]){  //有交集
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],right);
            }
        }
        return list.toArray(new int[list.size()][]);    //集合转数组，二维数组必须指定行或列
    }
}
