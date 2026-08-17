package leetcode_128;

import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int maxLen=1;
        int curLen=1;

        Set<Integer> set=new TreeSet<>();
        for(int num:nums){
            set.add(num);
        }

        int[] arr=set.stream().mapToInt(Integer::intValue).toArray(); //set集合转为数组，方便进行比较
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]+1==arr[i+1]){
                curLen+=1;
                maxLen=Math.max(maxLen,curLen);
            }else{
                curLen=1;
            }
        }

        return maxLen;
    }
}