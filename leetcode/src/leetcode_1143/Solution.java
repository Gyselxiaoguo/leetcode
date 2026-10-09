package leetcode_1143;

import java.util.Map;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        //dp[i][j] 的定义：text1 的前 i 个字符，和 text2 的前 j 个字符，最长公共子序列的长度。
        int[][] dp=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    /*
                    - text1 第 i 个字符 == text2 第 j 个字符
                    - 那这个字符**一定可以加入公共子序列**
                    - 公共子序列长度 = 两个字符串都去掉这个字符后的 LCS 长度 + 1
                    * */
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    /*
                    当前两个字符不一样，不能同时选这两个字符**。
                    有两种候选方案，取更大值：
                    1. **方案 A：不要 text1 的第 i 个字符**
                    只看 text1 前 `i-1` 个字符 和 text2 前 j 个字符
                    结果：`dp[i-1][j]`
                    2. **方案 B：不要 text2 的第 j 个字符**
                    只看 text1 前 i 个字符 和 text2 前 `j-1` 个字符
                    结果：`dp[i][j-1]`
                    只能二选一，取最长的那个。
                    * */
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

/**
 * leetcode718原型
 */
/*class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp=new int[m+1][n+1];
        int res=0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    res=Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }
}*/