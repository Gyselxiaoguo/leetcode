package leetcode_120;

import java.util.Collections;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        List<Integer> preRow=triangle.get(0);
        for(int i=1;i<n;i++){
            List<Integer> curRow=triangle.get(i);
            curRow.set(0,curRow.get(0)+preRow.get(0));//每行第一个元素只与上一行的第一个元素有关
            for(int j=1;j<curRow.size()-1;j++){//掐头去尾的元素规律
                curRow.set(j,Math.min(preRow.get(j),preRow.get(j-1))+curRow.get(j));
            }
            curRow.set(curRow.size()-1,curRow.get(curRow.size()-1)+preRow.get(preRow.size()-1));//每行最后一个元素只与上一行最后一个元素有关
            preRow=curRow;
        }
        return preRow.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);//最后一行的最小值
    }
}