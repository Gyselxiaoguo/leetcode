package Test.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test11 {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(2,7);
        map.put(3,0);
        map.put(4,4);
        map.put(5,2);

        Integer res1 = map.values().stream().max(((o1, o2) -> o2 - o1)).orElse(-1);//0
        Integer res2 = map.values().stream().max(((o1, o2) -> o1 - o2)).orElse(-1);//7
        Integer res3 = map.values().stream().min(((o1, o2) -> o2 - o1)).orElse(-1);//7
        Integer res4 = map.values().stream().min(((o1, o2) -> o1 - o2)).orElse(-1);//0
        System.out.println(res1+","+res2+","+res3+","+res4);//
    }
}



