package leetcode_test;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>(Arrays.asList(1,2,3));
        int[] arr1=list1.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr1));
    }

}





