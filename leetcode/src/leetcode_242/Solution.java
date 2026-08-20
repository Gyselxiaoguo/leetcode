package leetcode_242;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen=s.length();
        int tLen=t.length();
        if(sLen!=tLen){
            return false;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<sLen;i++){
            char key=s.charAt(i);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for(int j=0;j<tLen;j++){
            char key=t.charAt(j);
            map.put(key,map.getOrDefault(key,0)-1);
        }
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            if(value!=null&&value!=0){
                return false;
            }
        }
        return true;
    }
}