package leetcode_120;

import java.util.Collections;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        for (int i = 1; i < n; i++) {
            List<Integer> curRow = triangle.get(i);
            List<Integer> preRow = triangle.get(i - 1);
            curRow.set(0,preRow.get(0)+curRow.get(0));  //每行第一个元素只与上一行的第一个元素有关
            int len = curRow.size();
            for (int j = 1; j < len - 1; j++) { //掐头去尾的元素规律
                curRow.set(j,Math.min(preRow.get(j),preRow.get(j-1))+curRow.get(j));
            }
            curRow.set(len-1,preRow.get(len-2)+curRow.get(len-1));  //每行最后一个元素只与上一行最后一个元素有关
        }

        List<Integer> list = triangle.get(n-1); //取出triangel中最后一个集合
        Collections.sort(list); //升序排序
        return list.get(0);
    }
}