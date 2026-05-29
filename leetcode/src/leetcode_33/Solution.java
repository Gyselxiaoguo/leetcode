package leetcode_33;

class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            //判断mid落在了哪个单调区间
            if(nums[left]<=nums[mid]) {
                //落在了左边
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else{
                //other
                if(nums[right]>=target&&target>nums[mid]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}