package leetcode_45;

class Solution {
    public int jump(int[] nums) {
        int ans=0;
        int maxpos=0;
        int end=0;
        for (int i = 0; i < nums.length-1; i++) {
            maxpos = Math.max(nums[i] + i, maxpos);
            if(end==i){
                ans++;
                end=maxpos;
            }
        }
        return ans;
    }
}