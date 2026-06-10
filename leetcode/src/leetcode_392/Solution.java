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