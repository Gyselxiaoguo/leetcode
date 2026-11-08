package leetcode_392;

/**
 * 通过不断裁取来判断
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m>n){
            return false;
        }

        for(char c:s.toCharArray()){
            int idx=t.indexOf(c);
            if(idx==-1){
                return false;
            }
            t=t.substring(idx+1);

        }
        return true;
    }
}