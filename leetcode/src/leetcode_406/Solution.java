package leetcode_406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list=new ArrayList<>();
        //按第一个元素降序，第二个升序排列
        Arrays.sort(people,(a, b)->a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(b[0],a[0]));
        for(int[] p:people){
            int idx=p[1];
            if(list.size()<=idx){
                list.add(p);    //直接添加
            }else{
                list.add(idx,p);    //指定位置之前插入
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}