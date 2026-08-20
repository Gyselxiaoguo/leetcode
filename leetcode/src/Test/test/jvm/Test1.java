package Test.test.jvm;

public class Test1 {
    public static void main(String[] args) {
        Car car = new Car();
        Class<? extends Car> c1 = car.getClass();
        System.out.println(c1);
        ClassLoader classLoader = c1.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());

        Class<String> c2 = String.class;
        System.out.println(c2.getClassLoader());
    }
}
class Car{
    int age;
}