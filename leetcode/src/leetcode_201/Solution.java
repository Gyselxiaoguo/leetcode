package leetcode_201;

class Solution {
    /**
     * 寻找left与right的最长公共前缀
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        int ans=0;
        for (int i = 0; i < 32; i++) {
            if((left>>i)==(right>>i)){
                ans=(left>>i)<<i;
                break;
            }
        }
        return ans;
    }
}