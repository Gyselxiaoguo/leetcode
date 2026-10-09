package Test.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(6,3,2,9,8,1));
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());//求和
        list.sort((a,b)->a-b);//自定义排序
        System.out.println(list);


        int[] array = list.stream().mapToInt(Integer::intValue).toArray();//转int[]类型
        System.out.println(Arrays.toString(array));


    }
}
