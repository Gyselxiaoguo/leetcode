package leetcode_228;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> res=new ArrayList<>();
        if(nums.length==0){
            return res;
        }

        int start=nums[0];
        for(int i=1;i<=nums.length;i++){

            if(i==nums.length||nums[i-1]+1!=nums[i]){
                int end=nums[i-1];
                res.add(start==end?start+"":start+"->"+end);
                if(i<nums.length){
                    start=nums[i];
                }
            }
        }

        return res;
    }
}