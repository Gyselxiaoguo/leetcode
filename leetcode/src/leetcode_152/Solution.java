package leetcode_152;

class Solution {
    public int maxProduct(int[] nums) {
        int max_res=nums[0];
        int cur_max=nums[0];
        int cur_min=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp_max=cur_max;
            int temp_min=cur_min;
            cur_max=Math.max(temp_max*nums[i],Math.max(temp_min*nums[i],nums[i]));
            cur_min=Math.min(temp_max*nums[i],Math.min(temp_min*nums[i],nums[i]));
            max_res=Math.max(max_res,cur_max);
        }
        return max_res;
    }
}