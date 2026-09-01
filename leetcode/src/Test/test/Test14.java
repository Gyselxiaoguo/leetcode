package Test.test;

import javax.swing.plaf.SliderUI;
import java.util.*;
import java.util.stream.Collectors;

public class Test14 {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(16,1);
        map.put(23,23);
        map.put(1,3);
        map.put(2,2);

        int[] array = map.entrySet().stream().sorted((a, b) -> a.getValue() - b.getValue())
                .limit(2)
                .map(a -> a.getKey())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(array));
    }
}


