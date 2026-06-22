package leetcode_learning.reflection;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取Student这个类的实例
        Person person=new Student();
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());
        Class c2 = Student.class;
        System.out.println(c2.hashCode());
        Class c3 = Class.forName("leetcode_learning.reflection.Student");
        System.out.println(c3.hashCode());
    }
}

class Person{
    String name;
    public Person(){
    }
    public Person(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{
    public Student(){
        this.name="学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name="教师";
    }
}