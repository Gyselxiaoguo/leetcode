package leetcode_416;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2==1){
            return false;
        }
        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for (int num : nums) {
            boolean[] temp_dp = Arrays.copyOf(dp, dp.length);
            for (int i = 0; i <= target; i++) {
                if(dp[i]&&i+num<=target){
                    temp_dp[i+num]=dp[i];
                }
            }
            dp=temp_dp;
            if(dp[target]){
                return true;
            }
        }
        return dp[target];
    }
}