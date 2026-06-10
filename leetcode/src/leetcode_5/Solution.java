package leetcode_5;

class Solution {
    public String longestPalindrome(String s) {
        int maxLen=0;
        int start=0;
        for (int i = 0; i < s.length(); i++) {
            //babad
            int left=i;
            int right=i;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                if(right-left+1>maxLen){
                    maxLen=right-left+1;
                    start=left;
                }
                left--;
                right++;
            }
            //baab
            left=i;
            right=i+1;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                if(right-left+1>maxLen){
                    maxLen=right-left+1;
                    start=left;
                }
                left--;
                right++;
            }
        }
        return s.substring(start,start+maxLen);
    }
}