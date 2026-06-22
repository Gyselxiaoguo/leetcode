package leetcode_136;

class Solution {
    /**
     * 异或运算
     * @param nums
     * @return
     * 时间复杂度o(n)
     * 空间复杂度o(1)
     */
    public int singleNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }

}