package leetcode_209;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen=Integer.MAX_VALUE;
        int left=-1;
        int right=-1;
        int sum=0;
        while (true){
            if(sum<target){ //右指针右移，sum变大，元素增加
                right++;
                if(right>=nums.length){
                    break;
                }
                sum+=nums[right];
            }else { //左指针右移，sum减小，元素减少
                if(right-left<minLen){
                    minLen=right-left;
                }
                left++;
                if(left>right){
                    break;
                }
                sum-=nums[left];
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}