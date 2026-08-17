package leetcode_283;

class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        for(int right=1;right<nums.length;){
            if(nums[left]==0&&nums[right]!=0){
                swap(nums,left,right);
                left++;
                right++;
            }else if(nums[left]==0&&nums[right]==0){
                right++;
            }else if(nums[left]!=0&&nums[right]==0){
                left++;
                right++;
            }else if(nums[left]!=0&&nums[right]!=0){
                left++;
                right++;
            }
        }
    }
    private void swap(int[] nums,int a,int b){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
        }
}