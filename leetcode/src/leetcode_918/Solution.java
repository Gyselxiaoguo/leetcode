package leetcode_918;

import java.util.Arrays;

class Solution {
    /**
     * 数组总和-最小子数组之和（可能为正/负）， 最大子数组之和，找最大的哪一个
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int curMax=nums[0];
        int globalMax=nums[0];
        int curMin=nums[0];
        int globalMin=nums[0];

        for (int i = 1; i < nums.length; i++) {
            curMax=Math.max(nums[i],curMax+nums[i]);
            globalMax=Math.max(globalMax,curMax);

            curMin=Math.min(nums[i],curMin+nums[i]);
            globalMin=Math.min(globalMin,curMin);
        }

        int sum= Arrays.stream(nums).sum();

        //全为负数情况
        if(sum==globalMin){
            return globalMax;
        }

        return Math.max(sum-globalMin,globalMax);
    }

}