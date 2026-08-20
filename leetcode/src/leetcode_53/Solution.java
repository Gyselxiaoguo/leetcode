package leetcode_53;


class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }

        int globalMax=nums[0];
        int[] maxNums=new int[n];
        maxNums[0]=nums[0];
        for(int i=1;i<n;i++){
            int temp=nums[i]+maxNums[i-1];
            if(temp>nums[i]){
                maxNums[i]=temp;
            }else{
                maxNums[i]=nums[i];
            }
            globalMax=Math.max(globalMax,maxNums[i]);
        }
        return globalMax;
    }
}