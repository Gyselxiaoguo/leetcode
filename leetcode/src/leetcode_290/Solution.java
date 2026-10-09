package leetcode_290;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strArr = s.split(" ");
        if(strArr.length!=pattern.length()){
            return false;
        }
        Map<Character,String> map=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char key=pattern.charAt(i);
            String value = strArr[i];
            if(!map.containsKey(key)&&!map.containsValue(value)){   //key,value都不同，记录映射
                map.put(key,value);
            }else if(!map.containsKey(key)&& !Objects.equals(map.get(key), value)){ //key不存在，但value相同，返回false
                return false;
            } else if (map.containsKey(key)&& !Objects.equals(map.get(key), value)) {  //  key存在，但value不同
                return false;
            }
        }
        return true;
    }
}