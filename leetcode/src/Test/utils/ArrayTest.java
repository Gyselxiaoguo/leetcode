package Test.utils;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr={3,5,1,4,2};
        int[] arr2=new int[5];
        int[][] arr1={{7,0},{5,2},{6,1},{5,0},{4,4}};
        System.out.println(Arrays.stream(arr).max().orElse(Integer.MIN_VALUE));//求最大值
        System.out.println(Arrays.stream(arr).min().orElse(Integer.MAX_VALUE));//求最小值

        int[] array = Arrays.stream(arr).sorted().toArray();
        Integer[] array1 = Arrays.stream(arr).boxed().sorted().toArray(Integer[]::new);

        Arrays.sort(arr1, (a, b)->a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(b[0],a[0]));//按第一个元素降序，第二个元素升序
        System.out.println(Arrays.deepToString(arr1));

        System.arraycopy(arr,0,arr2,0,arr.length);
        System.out.println(Arrays.toString(arr2));
    }
}
