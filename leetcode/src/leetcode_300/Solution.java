package leetcode_300;

import java.util.Arrays;

/**
 * 根据满足条件的最长子串更新
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

        int[] dp=new int[n];    // dp[i]：以nums[i]结尾的最长递增子序列长度
        Arrays.fill(dp,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(Integer.MIN_VALUE);
    }
}