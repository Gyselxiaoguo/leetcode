package leetcode_918;

import java.util.Arrays;

class Solution {
    /**
     * 数组总和-最小子数组之和（可能为正/负）， 最大子数组之和，找最大的哪一个
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int[] curMax=new int[n];
        int[] curMin=new int[n];
        curMax[0]=nums[0];
        curMin[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            curMax[i]=Math.max(nums[i],curMax[i-1]+nums[i]);
            curMin[i]=Math.min(nums[i],curMin[i-1]+nums[i]);
        }
        int totalMax=Arrays.stream(curMax).max().orElse(Integer.MIN_VALUE);
        int totalMin=Arrays.stream(curMin).min().orElse(Integer.MAX_VALUE);
        int sum=Arrays.stream(nums).sum();


        if (totalMax < 0) { //数组中所有元素全都是负数
            return totalMax;
        }
        return Math.max(totalMax,sum-totalMin);//连续最大，总和-连续最小
    }
}