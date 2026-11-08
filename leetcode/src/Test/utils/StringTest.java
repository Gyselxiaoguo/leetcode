package Test.utils;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String s = "dog   cat  cat dog";
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));

        System.out.println(s.lastIndexOf('x'));

        String s1 = s.replaceAll("\\s+", " ");  //replaceAll   使用正则表达式匹配（\s+ 匹配一个或多个空格）
        System.out.println(s1);

        String s2 = s.replace("  ", "$");   //replace   固定字符串匹配
        System.out.println(s2);

        int i = Integer.parseInt("23");
        System.out.println(i*10);
    }
}
