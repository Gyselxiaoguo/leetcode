package leetcode_14;

/**
 * 遍历第一个字符串中的每个字符，检查其他字符串中对应位置的字符
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }

        String s=strs[0];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            for(String str:strs){
                char cc=i<str.length()?str.charAt(i):'#';
                if(c!=cc){
                    return s.substring(0,i);
                }
            }
        }
        return s;
    }
}