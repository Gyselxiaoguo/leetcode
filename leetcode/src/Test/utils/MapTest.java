package Test.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();  //转为set集合
        Collection<Integer> values = map.values();

        //得到 int[]
        int[] array = map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue())
                .mapToInt(a -> a.getKey())
                .limit(3)
                .toArray();

        //得到 Integer[]
        Integer[] array1 = map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue())
                .map(a -> a.getKey())
                .limit(3)
                .toArray(Integer[]::new);
    }


}
