package leetcode_learning.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class c1 = Class.forName("leetcode_learning.reflection.Student1");
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        Student1 user = (Student1) constructor.newInstance("Gysel", 1, 23); //通过构造函数创建对象
        System.out.println(user);

        Student1 user2 = (Student1) c1.newInstance();
        Method setName = c1.getMethod("setName", String.class);
        setName.invoke(user2,"小郭"); //函数调用，invoke是函数激活
        System.out.println(user2.getName());

        Student1 user3 = (Student1) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);   // 放开私有字段的访问权限
        name.set(user3,"小郭2");  //改变属性值，即使私有也可以改变
        System.out.println(user3.getName());
    }
}
