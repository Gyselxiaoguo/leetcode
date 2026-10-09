package leetcode_205;

/**
 * 通过找字符第一次出现的索引判断同构
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m)return false;
        for (int i = 0; i < n; i++) {
            if(s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}