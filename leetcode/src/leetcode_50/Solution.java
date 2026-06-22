package leetcode_50;

class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(n<0){
            N=-N;
        }
        double ans=1.0;
        while (N>0){
            if((N&1)==1){
                ans*=x;
            }
            x*=x;
            N>>=1;
        }
        return n<0?1/ans:ans;
    }
}