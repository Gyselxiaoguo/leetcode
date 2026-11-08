package leetcode_26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0;
        for(int fast=1;fast<nums.length;fast++){    //元素个数>2，使用双指针去重
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;
    }
}