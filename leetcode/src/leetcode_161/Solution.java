package leetcode_161;

class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[mid+1]){   // 下坡，峰值在左侧（含mid）
                right=mid;
            }else { // 上坡，峰值在右侧
                left=mid+1;
            }
        }
        return right;
    }
}