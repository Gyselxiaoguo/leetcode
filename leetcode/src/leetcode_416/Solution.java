package leetcode_416;

import java.util.Arrays;

/**
 *  01背包的应用
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum%2==1){
            return false;
        }

        int target=sum/2;
        int n=nums.length;
        int[][] dp=new int[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=target;i++){
            if(i>=nums[0]){
                dp[0][i]=nums[0];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                if(j<nums[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }
            }
        }

        return dp[n-1][target]==target;
    }
}