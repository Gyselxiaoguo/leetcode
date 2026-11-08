package leetcode_494;

import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum= Arrays.stream(nums).sum();
        if((sum+target)%2!=0){
            return 0;
        }
        int newTarget=(sum+target)/2;
        if(newTarget<0){
            return 0;
        }
        int n=nums.length;
        int[][] dp=new int[n][newTarget+1];

        dp[0][0]=1;
        for(int j=0;j<=newTarget;j++){
            if(j==nums[0]){
                dp[0][j]+=1;    //就是防止元素为0；
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=newTarget;j++){
                if(j<nums[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][newTarget];
    }
}