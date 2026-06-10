package leetcode_134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int ans=0;
        int sum=0;
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int diff=gas[i]-cost[i];
            sum+=diff;
            if(mn>sum){
                mn=sum;
                ans=(i+1)%n;
            }
        }
        return sum<0?-1:ans;
    }
}