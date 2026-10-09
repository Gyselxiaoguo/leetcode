package leetcode_13;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int num=map.get(c);
            if(i==0){
                res+=num;
                continue;
            }
            if(((c=='V'||c=='X')&&s.charAt(i-1)=='I')
                    ||((c=='L'||c=='C')&&s.charAt(i-1)=='X')
                    ||((c=='D'||c=='M')&&s.charAt(i-1)=='C')){
                res=res-2*map.get(s.charAt(i-1))+num;
            }else{
                res+=num;
            }
        }
        return res;
    }
}