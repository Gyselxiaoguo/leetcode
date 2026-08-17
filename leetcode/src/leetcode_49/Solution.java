package leetcode_49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //对长度一样的字符串进行排序，相等的为字母异位词，应放到一个列表中
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}