package leetcode_31;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i >=0; i--) {
            for (int j = nums.length-1; j > i ; j--) {
                if(nums[i]<nums[j]){
                    swap(i,j,nums);
                    Arrays.sort(nums,i+1,nums.length);
                    return;
                }
            }
        }
        //当前已经是最大了的，轮回到最小
        Arrays.sort(nums);
    }
    private void swap(int a,int b,int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}