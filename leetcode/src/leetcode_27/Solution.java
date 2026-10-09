package leetcode_27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            if(nums[left]==val){
                swap(nums,left,right);
                right--;
            }else{
                left++;
            }
        }
        return right+1;
    }
    private void swap(int[] nums,int l,int r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}