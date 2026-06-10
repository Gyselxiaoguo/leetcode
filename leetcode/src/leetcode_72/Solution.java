package leetcode_72;

class Solution {
    //视频url：https://www.bilibili.com/video/BV1NGGEz3ECE/?spm_id_from=333.337.search-card.all.click&vd_source=824b9f1dfb49e7b00400a7367deba785
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    int insert=dp[i][j-1];
                    int delete=dp[i-1][j];
                    int replace=dp[i-1][j-1];
                    dp[i][j]=Math.min(insert,Math.min(delete,replace))+1;
                }
            }
        }
        return dp[m][n];
    }
}