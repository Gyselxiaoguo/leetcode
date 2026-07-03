package Test.test;

import java.util.Arrays;
import java.util.List;

public class Test7 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("as","a","b","c","d","e");
        words.stream()
                .parallel() // 切换并行执行后续操作
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
