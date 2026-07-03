package Test.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);
        Integer[] array = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(array));

        String[] s={"a","b","c"};
        List<String> list2 = new ArrayList<>(Arrays.asList(s));
        list2.add("d");
        System.out.println(list2);

        int[] arr={1,2,3,4,5};
        List<Integer> collect = Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toList());
        System.out.println(collect);
    }
}
