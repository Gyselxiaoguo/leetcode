package leetcode_392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen=t.length();
        if(sLen==tLen){
            return s.equals(t);
        }
        int i=0;
        int j=0;
        while (i<s.length()){
            if(j==t.length()){  //长串遍历完了，直接返回false
                return false;
            }
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }
        return true;
    }
}

/**
 * 动态规划
 */
/*class Solution {
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m>n){
            return false;
        }

        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n]==m;
    }
}*/