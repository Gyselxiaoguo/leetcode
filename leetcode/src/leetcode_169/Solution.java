package leetcode_169;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Set<Map.Entry<Integer,Integer>> entries=map.entrySet();

        return entries.stream()
        .sorted((a,b)->b.getValue()-a.getValue())   //按值降序排序
        .map(entry->entry.getKey()) //过滤，只要key
        .toArray(Integer[]::new)[0];
    }
}