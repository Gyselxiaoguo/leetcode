package leetcode_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        if(nums[0]>0||nums[n-1]<0){
            return res;
        }

        for(int i=0;i<n;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //去重
            int left=i+1;
            int right=n-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    List<Integer> list=new ArrayList<>();
                    Collections.addAll(list,nums[i],nums[left],nums[right]);
                    res.add(list);  //记录

                    while(left<right&&nums[left]==nums[left+1]){    //去重
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){  //去重
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}