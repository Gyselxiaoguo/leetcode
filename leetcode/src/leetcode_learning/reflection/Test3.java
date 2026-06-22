package leetcode_learning.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("leetcode_learning.reflection.Student1");
        /* 类 */
        System.out.println(c1.getName());   //获得该类的全类名
        System.out.println(c1.getSimpleName()); //获得该类的类名
        /* 属性 */
        Field[] fields = c1.getDeclaredFields();    //获得该类中的所有属性的全类名
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println(c1.getDeclaredField("age")); //指定获取类中某一属性的全类名
        /* 方法 */
        Method[] declaredMethods = c1.getDeclaredMethods(); //获取该类中所有方法的全类名
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println(c1.getDeclaredMethod("getName", null));  //指定获取方法的全类名
        System.out.println(c1.getDeclaredMethod("setName", String.class));
        /* 构造方法 */
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();  //获取构造方法的全类名
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println(c1.getDeclaredConstructor(String.class,int.class,int.class));    //指定获取构造方法的全类名
    }
}
