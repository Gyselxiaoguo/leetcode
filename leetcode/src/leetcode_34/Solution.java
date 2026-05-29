package leetcode_34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=binSearch(nums,target,true);
        int right=binSearch(nums,target,false);
        return new int[]{left,right};
    }
    //二叉搜索
    private int binSearch(int[] nums, int target,boolean isLeft){
        int left=0;
        int right=nums.length-1;
        int index=-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else {
                index=mid;
                if(isLeft){
                    //找开始位置
                    right=mid-1;
                }else {
                    //找结束位置
                    left=mid+1;
                }
            }
        }
        return index;
    }
}