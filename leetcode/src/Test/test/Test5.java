package Test.test;

public class Test5 {
    public static void main(String[] args) {

        // 1. 字面量：直接进入字符串常量池
        String s1 = "Java";

        // 2. new String：在堆中创建新对象，不在常量池
        String s2 = new String("Java");

        // == 比较内存地址
        System.out.println(s1 == s2); // false：一个在常量池，一个在堆
        System.out.println(s1.equals(s2));

        // 3. 调用 intern()：去常量池找"Java"
        String s3 = s2.intern();

        System.out.println(s1 == s3); // true：s3 拿到了常量池里 s1 的引用
        System.out.println(s1.equals(s3));

    }
}
