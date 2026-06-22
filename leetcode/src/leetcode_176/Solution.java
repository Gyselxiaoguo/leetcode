package leetcode_176;

class Solution {
    /**
     * 找5的个数，10=2*5
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans=0;
        while (n>0){
            ans+=n/5;
            n/=5;
        }
        return ans;
    }
}