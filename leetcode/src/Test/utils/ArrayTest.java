package Test.utils;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr={3,5,1,4,2};
        System.out.println(Arrays.stream(arr).max().orElse(Integer.MIN_VALUE));//求最大值
        System.out.println(Arrays.stream(arr).min().orElse(Integer.MAX_VALUE));//求最小值
    }
}
