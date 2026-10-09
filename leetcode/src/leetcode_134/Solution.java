package leetcode_134;

import java.util.Arrays;

/**
 * 前缀和最小值对应的下一个位置就是合法起点。
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas= Arrays.stream(gas).sum();
        int totalCost=Arrays.stream(cost).sum();
        if(totalGas-totalCost<0){
            return -1;
        }
        int[] nums=new int[gas.length]; //记录前缀和
        nums[0]=gas[0]-cost[0];
        int idx=0;  //记录前缀和最小位置
        int totalMin=nums[0];
        for(int i=1;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            nums[i]=nums[i-1]+diff;
            if(totalMin>nums[i]){
                totalMin=nums[i];
                idx=i;
            }
        }
        return (idx+1)%gas.length;
    }
}