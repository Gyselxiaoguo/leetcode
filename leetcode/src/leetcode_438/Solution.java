package leetcode_438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> pMap=new HashMap<>();
        for(char c:p.toCharArray()){
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }
        int valid=pMap.size();

        int start=0;
        int count=0;
        Map<Character,Integer> winMap=new HashMap<>();
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            if(pMap.containsKey(ch)){
                winMap.put(ch,winMap.getOrDefault(ch,0)+1);
                if(winMap.get(ch).equals(pMap.get(ch))){
                    count++;
                }
            }

            if(r-start+1>p.length()){   //窗口>p的长度，收缩
                char lCh=s.charAt(start);
                if(winMap.containsKey(lCh)){
                    if(winMap.get(lCh).equals(pMap.get(lCh))){
                        count--;
                    }
                    winMap.put(lCh,winMap.get(lCh)-1);
                }
                start++;
            }

            if(count==valid){
                res.add(start);
            }
        }
        return res;
    }
}