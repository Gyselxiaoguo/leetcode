package Test.utils;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> set=new HashSet<>(Arrays.asList(1,2,3,4,5,5));
        System.out.println(set);
        list.set(2,666);    //设置指定位置的值
        System.out.println(list);
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();//List<Integer> -> int[]
        List<int[]> list1=new ArrayList<>();
        list1.add(new int[]{1,2});
        list1.add(new int[]{3,4});
        int[][] array1 = list1.toArray(new int[list1.size()][]);    //List<int[]> -> int[][]

        list.sort((a,b)->b-a);  //指定排序规则
        System.out.println(list);

        list.remove(Integer.valueOf(2));    //按值删除，传入对象
        System.out.println(list);

        Collections.shuffle(list);  //打乱list的顺序
        Collections.reverse(list);  //翻转list的顺序

        int sum = list.stream().mapToInt(Integer::intValue).sum();  //因为是包装类，所以转为基本数据类型才 sum

        List<int[]> list2 = Arrays.asList(new int[]{1, 2, 3});
        System.out.println(list2);
    }
}
