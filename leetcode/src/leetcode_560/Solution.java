package leetcode_560;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res  = 0;
        int[] preSum = new int[n + 1];  //前缀和
        for(int i = 1; i <= n;i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for(int i = 0; i < n;i++){
            for(int j = i + 1; j <= n;j++){
                if(preSum[j] - preSum[i] == k){
                    res++;
                }
            }
        }
        return res;
    }
}