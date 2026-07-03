package Test.test;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Test9 {
    static class User{
        private String name;
        private int age;
        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + ":" + age;
        }
    }

    // 3. 自定义对象（传入Comparator，按年龄降序）
    static void testTreeSetCustom() {
        TreeSet<User> userSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u2.age - u1.age; // 降序
            }
        });
        userSet.add(new User("张三", 20));
        userSet.add(new User("李四", 25));
        userSet.add(new User("王五", 22));
        // 遍历输出：李四:25 王五:22 张三:20（按年龄降序）
        for (User user : userSet) {
            System.out.println(user);
        }
    }

    public static void testLinkedHashSet() {
        LinkedHashSet<String> strSet = new LinkedHashSet<>();
        strSet.add("b");
        strSet.add("a");
        strSet.add("c");
        // 遍历输出：b a c（和添加顺序一致）
        for (String str : strSet) {
            System.out.print(str + " ");
        }
    }

    public static void main(String[] args) {
        testLinkedHashSet();
    }
}
