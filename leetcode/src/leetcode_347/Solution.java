package leetcode_347;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //1.定义一个HashMap，他不会自动排序
        Map<Integer,Integer> map=new HashMap<>();
        //2.遍历，key:数字，value：数量
        for (int num : nums) {
            if(map.get(num)==null){
                //第一次出现
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }
        //3.按值排序

        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        //4.返回前k个键的值
        int[] newNums=new int[k];
        for (int i = 0; i < k; i++) {
            newNums[i]=list.get(i).getKey();
        }
        return newNums;
    }
}