package leetcode_3;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        String maxStr="";
        int maxLen=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            //字符不在maxStr中，拼接
            if(maxStr.indexOf(c)==-1){
                maxStr+=c;
            }else {
                //字符在maxStr中，从maxStr中取出重复字符之后的串，然后再与新字符拼接
                int reIndex=maxStr.indexOf(c);
                maxStr=maxStr.substring(reIndex+1);
                maxStr+=c;
            }
            maxLen=Math.max(maxLen,maxStr.length());
        }
        return maxLen;
    }
}