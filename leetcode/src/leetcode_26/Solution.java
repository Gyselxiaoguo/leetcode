package leetcode_26;

class Solution {
    //双指针去重
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        //元素个数>2，使用双指针去重
        int slow=0;
        int fast=1;
        while (fast<nums.length){
            if(nums[slow]==nums[fast]){
                fast++;
            }else {
                slow++;
                nums[slow]=nums[fast];
                fast++;
            }
        }
        return slow+1;
    }
}