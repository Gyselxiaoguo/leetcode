package leetcode_97;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean[][] dp=new boolean[s2.length()+1][s1.length()+1];
        dp[0][0]=true;
        /* 找到s3以哪个字符串打头*/

        for(int j=1;j<=s1.length();j++){    // 边界：只取s1，不取s2;匹配失败直接中断循环
            dp[0][j] = dp[0][j-1] && s1.charAt(j-1)==s3.charAt(j-1);
        }
        for(int i=1;i<=s2.length();i++){    // 边界：只取s2，不取s1;匹配失败直接中断循环
            dp[i][0] = dp[i-1][0] && s2.charAt(i-1)==s3.charAt(i-1);
        }

        /**
         * 两种方式：
         *  1.追加s1，判断s3是否以s1结尾
         *  2.追加s2，判断s3是否以s2结尾
         */
        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                dp[i][j]=dp[i-1][j]&&(s3.charAt(i+j-1)==s2.charAt(i-1))
                        ||dp[i][j-1]&&(s3.charAt(i+j-1)==s1.charAt(j-1));
            }
        }
        return dp[s2.length()][s1.length()];
    }
}