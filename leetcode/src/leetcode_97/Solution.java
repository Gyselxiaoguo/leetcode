package leetcode_97;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n=s2.length();
        if (s3.length() != m + n) return false;
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        /* 找到s3以哪个字符串打头*/
        for (int i = 1; i <= m&&(s1.charAt(i-1)==s3.charAt(i-1)); i++) {// 边界：只取s1，不取s2;匹配失败直接中断循环
            dp[i][0]=true;
        }
        for (int i = 1; i <= n&&(s2.charAt(i-1)==s3.charAt(i-1)); i++) {// 边界：只取s2，不取s1;匹配失败直接中断循环
            dp[0][i]=true;
        }

        /**
         * 两种方式：
         *  1.追加s1，判断s3是否以s1结尾
         *  2.追加s2，判断s3是否以s2结尾
         */
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j]=dp[i-1][j]&&(s3.charAt(i+j-1)==s1.charAt(i-1))
                        ||dp[i][j-1]&&(s3.charAt(i+j-1)==s2.charAt(j-1));
            }
        }
        return dp[m][n];
    }
}