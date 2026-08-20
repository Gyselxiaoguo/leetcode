package leetcode_300;

import java.util.Arrays;

/**
 * 根据满足条件的最长子串更新
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return n;
        }
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(1);
    }
}