package leetcode_58;

class Solution {
    public int lengthOfLastWord(String s) {
        s=s.strip();
        int n=s.length();
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==' '){
                return n-i-1;
            }
        }
        return n;
    }
}