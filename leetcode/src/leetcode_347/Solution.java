package leetcode_347;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int[] res=map.entrySet().stream()
                .sorted((a,b)->b.getValue()-a.getValue())   //可以按键/值 升序/降序 排序
                .limit(k)   //仅要前k个
                .map(entry->entry.getKey()) //仅要key
                .mapToInt(Integer::intValue)    //Integer->int
                .toArray();

        return res;
    }
}