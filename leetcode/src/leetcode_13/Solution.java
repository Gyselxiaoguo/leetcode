package leetcode_13;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map= new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum=0;
        int l=0;
        int r=1;
        while (l<s.length()){
            if(r<s.length()&&map.get(s.charAt(l))<map.get(s.charAt(r))){
                //需要做减法，l,r都右移2位
                sum+=map.get(s.charAt(r))-map.get(s.charAt(l));
                l+=2;
                r+=2;
            }else {
                sum+=map.get(s.charAt(l));
                l++;
                r++;
            }
        }
        return sum;
    }
}