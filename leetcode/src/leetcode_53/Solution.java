package leetcode_53;

import java.util.Arrays;

class Solution {

    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int globalMax=nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax=Math.max(nums[i],nums[i]+curMax);
            globalMax=Math.max(curMax,globalMax);
        }
        return globalMax;
    }
}