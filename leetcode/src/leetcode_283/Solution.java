package leetcode_283;

class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return;
        }
        int left=0;
        int right=1;
        while(right<n){
            if(nums[left]==0&&nums[right]!=0){
                swap(nums,left,right);
                left++;
                right++;
            }else if(nums[left]==0&&nums[right]==0){
                right++;
            }else{
                left++;
                right++;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}