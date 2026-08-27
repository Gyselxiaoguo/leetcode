package Test.test;

import javax.swing.plaf.SliderUI;
import java.util.*;
import java.util.stream.Collectors;

public class Test14 {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("key1",1);
        map.put("key2",2);
        map.putIfAbsent("key2",3);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }


    }
}


