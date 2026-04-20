package leetcode_53;

import java.util.Arrays;

class Solution {
    /***
     * 思路：遍历，前面元素之和>0时，加到当前元素上
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int[] newNums=new int[len];
        System.arraycopy(nums,0,newNums,0,nums.length);
        for (int i = 1; i < nums.length; i++) {
            if(newNums[i-1]>0)newNums[i]+=newNums[i-1];
        }
        Arrays.sort(newNums);
        return newNums[len-1];
    }
}