package leetcode_76;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0||s.length()<t.length()){
            return "";
        }

        //统计字符串t中每个字符出现的次数
        Map<Character,Integer> need=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int needKind=need.size();    //t中字符种类的个数
        //每当滑动窗口中包含的字符总类个数=t中某个字符种类个数时，valid++。valid==count时，滑动窗口中的字符串可以覆盖t
        int valid=0;

        //统计滑动窗口中每个字符出现的次数
        Map<Character,Integer> win=new HashMap<>();
        int minStart=0;
        int minLen=Integer.MAX_VALUE;
        int left=0;
        int right=0;

        while (right<s.length()){
            //统计窗口中各种字符出现的次数
            char rChar = s.charAt(right);
            win.put(rChar,win.getOrDefault(rChar,0)+1);

            //判断是否有字符数量达标
            if(Objects.equals(win.get(rChar), need.getOrDefault(rChar, -1))){   //达标,该种元素数量>=mapT中对应元素
                //要保证不能同种元素重复使valid+1
                valid++;
            }

            while(valid==needKind){   //窗口已覆盖t，尝试收缩窗口
                //尝试更新覆盖t的最小窗口长度
                int curLen = right - left + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    minStart = left;
                }
                //left右移前，先在win中将该位置的元素数量-1
                char lChar = s.charAt(left);
                if(need.get(lChar)!=null&&Objects.equals(win.get(lChar), need.get(lChar))){ //减之前刚好等于需求，减完就不满足，valid减少
                    valid--;
                }
                win.put(lChar,win.get(lChar)-1);
                left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);
    }
}