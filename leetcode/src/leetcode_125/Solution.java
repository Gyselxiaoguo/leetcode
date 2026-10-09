package leetcode_125;

class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<=r){
            //不是字母/数字，跳过
            while(l<=r&&!Character.isLetterOrDigit(s.charAt(l))){ 
                l++;
            }
            while(r>=l&&!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(l > r) break;
            char lc=s.charAt(l);
            char rc=s.charAt(r);
            //左右指针均是字母/数字
            if((Character.isLetter(lc)&&Character.isLetter(rc)&&Character.toLowerCase(lc)==Character.toLowerCase(rc))
            ||(lc==rc)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}