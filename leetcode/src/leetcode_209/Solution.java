package leetcode_209;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen=Integer.MAX_VALUE;
        int left=-1;
        int right=0;
        int sum=0;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>=target){
                minLen=Math.min(minLen,right-left);
                left++;
                sum-=nums[left];
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}