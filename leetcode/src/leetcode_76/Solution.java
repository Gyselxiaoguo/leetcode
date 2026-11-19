package leetcode_76;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public String minWindow(String s, String t) {
        if(s.isEmpty()||s.length()<t.length()){
            return "";
        }

        //统计字符串t中每个字符出现的次数
        Map<Character,Integer> tMap=new HashMap<>();
        for(Character c:t.toCharArray()){
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }


        int minStart=0;
        int minLen=Integer.MAX_VALUE;
        //统计滑动窗口中每个字符出现的次数
        Map<Character,Integer> win=new HashMap<>();
        int valid=0;
        int left=0;
        int right=0;

        while (right<s.length()){
            //1.统计窗口中各种字符出现的次数
            char rChar = s.charAt(right);
            if(tMap.containsKey(rChar)){
                win.put(rChar,win.getOrDefault(rChar,0)+1);
                if(win.get(rChar).equals(tMap.get(rChar))){
                    valid++;
                }
            }

            //2.窗口已覆盖t，尝试收缩窗口
            while(valid==tMap.size()){
                //尝试更新覆盖t的最小窗口长度
                int curLen = right - left + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    minStart = left;
                }
                //left右移前，先在win中将该位置的元素数量-1
                char lChar = s.charAt(left);
                if(win.containsKey(lChar)){
                    if(win.get(lChar).equals(tMap.get(lChar))){
                        valid--;
                    }
                    win.put(lChar,win.get(lChar)-1);
                }
                left++;
            }
            right++;
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);
    }
}