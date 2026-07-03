package leetcode_41;


class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i=0;
        while (i<n){
            if(nums[i]-1!=i&&nums[i]-1>=0&&nums[i]-1<n&&nums[i]!=nums[nums[i]-1]){  //nums[i]!=nums[nums[i]-1] 防止有重复元素
                swap(nums,i,nums[i]-1);
                continue;
            }
            i++;
        }

        int j;
        for (j = 0; j < n; j++) {
            if(nums[j]-1!=j){
                return j+1;
            }
        }
        return j+1;
    }

    private void swap(int[] nums, int num1, int num2) {
        int temp=nums[num1];
        nums[num1]=nums[num2];
        nums[num2]=temp;
    }
}