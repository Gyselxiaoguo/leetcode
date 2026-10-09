package leetcode_70;

class Solution {
    public int climbStairs(int n) {
        if(n<=1){
            return n;
        }
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];  //到达第 i 阶，可以从 i‑1 爬 1 步，或从 i‑2 爬 2 步
        }
        return dp[n-1];
    }
}