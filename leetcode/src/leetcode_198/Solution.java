package leetcode_198;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len=nums.length;
        int[] maxNums=new int[nums.length];
        if(len==1){
            return nums[0];
        } else if (len<=2) {
            return Math.max(nums[0],nums[1]);
        }else {
            //前两个元素值
            maxNums[0]=nums[0];
            maxNums[1]=Math.max(nums[0],nums[1]);
            //之后元素值
            for (int i = 2; i < maxNums.length; i++) {
                maxNums[i]=Math.max(maxNums[i-1],maxNums[i-2]+nums[i]);//取不偷该户&偷该户所获金额的最大值
            }
        }
        return maxNums[len-1];
    }
}