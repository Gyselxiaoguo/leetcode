package leetcode_3;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        String maxStr="";
        int maxLen=0;
        for (int i = 0; i < s.length(); i++) {
            //字符不在maxStr中，拼接
            if(maxStr.indexOf(s.charAt(i))==-1){
                maxStr+=s.charAt(i);
            }else {
                //字符在maxStr中，从maxStr中取出重复字符之后的串，然后再与新字符拼接
                int reIndex=maxStr.indexOf(s.charAt(i));
                maxStr=maxStr.substring(reIndex+1);
                maxStr+=s.charAt(i);
            }
            if(maxStr.length()>maxLen) maxLen=maxStr.length();
        }
        return maxLen;
    }
}