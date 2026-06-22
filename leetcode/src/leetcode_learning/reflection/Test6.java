package leetcode_learning.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//反射操作注解
public class Test6 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //获得注解
        Class c = Class.forName("leetcode_learning.reflection.Student1");
        MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());

        Field f = c.getDeclaredField("name");
        MyAnnotation2 myAnnotation1 = f.getAnnotation(MyAnnotation2.class);
        System.out.println(myAnnotation1.columnName());
        System.out.println(myAnnotation1.type());
        System.out.println(myAnnotation1.length());

    }
}

@MyAnnotation("db_student")
class Student1{
    @MyAnnotation2(columnName = "db_name",type = "String",length = 3)
    private String name;
    @MyAnnotation2(columnName = "db_id",type = "int",length = 10)
    private int id;
    @MyAnnotation2(columnName = "db_age",type = "int",length = 10)
    private int age;

    public Student1() {
    }

    public Student1(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String columnName();
    String type();
    int length();
}