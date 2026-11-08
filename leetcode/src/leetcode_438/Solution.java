package leetcode_438;

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        String templateStr=sortLetter(p);
        for(int i=0;i<s.length()-p.length()+1;i++){ //对s进行切分、比较
            String str=s.substring(i,i+p.length());
            String orderStr=sortLetter(str);
            if(orderStr.equals(templateStr)){
                res.add(i);
            }
        }
        return res;


    }
    private String sortLetter(String str){  //给字符串按字母升序排序
        char[] templateArr=str.toCharArray();
        Arrays.sort(templateArr);
        return new String(templateArr);
    }
}