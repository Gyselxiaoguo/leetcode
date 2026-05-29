package leetcode_153;

class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int min=nums[0];
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[left]<=nums[mid]){
                // 落在了左侧的单调递增区间
                min=Math.min(min,nums[left]);
                left=mid+1;
            }else {
                if(nums[mid]<=nums[right]){
                    //落在了右侧单增区间
                    min=Math.min(min,nums[mid]);
                    right=mid-1;
                }
            }
        }
        return min;
    }
}
