package leetcode_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0]>0)return res;
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
             if(nums[i]+nums[left]+nums[right]>0)right--;
             else if(nums[i]+nums[left]+nums[right]<0)left++;
             else {
                 res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                 while (left<right&&nums[left] == nums[left + 1]) left++;
                 while (left<right&&nums[right]==nums[right-1]) right--;
                 left++;
                 right--;
             }
            }
        }
        return res;
    }
}