package leetcode_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length())return new ArrayList<>();

        List<Integer> list=new ArrayList<>();
        int window=p.length();
        char[] arr = s.toCharArray();
        String sortedP=sortStr(p);//排序后的p

        for (int i = 0; i <= arr.length-window; i++) {
            String subStr = s.substring(i, i + window);
            String sortedSub = sortStr(subStr);
            if(sortedP.equals(sortedSub)){
                list.add(i);
            }
        }
        return list;
    }
    //排序，方便后续比较
    private String sortStr(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

}