package leetcode_75;

class Solution {
    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int i=0;
        while (i<=right){
            if(nums[i]==0){
                //交换i,left的元素，i,left右移
                swap(i,left,nums);
                i++;
                left++;
            }else if(nums[i]==2){
                //交换i,right的元素，right左移
                swap(i,right,nums);
                right--;
            }else {
                //i右移
                i++;
            }
        }
    }
    private void swap(int a,int b,int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}