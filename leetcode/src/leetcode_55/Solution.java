package leetcode_55;

class Solution {
    public boolean canJump(int[] nums) {
        int len=nums.length;
        int leap=1;
        for(int i=len-2;i>=0;i--){
            if(nums[i]>=leap){
                leap=1;
            }
            else{
                leap+=1;
            }
        }
        return leap <= 1;
    }
}