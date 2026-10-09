package Test.utils;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
    }
}
