package Test.test;

import java.util.Objects;

class User implements Cloneable{
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Test6{
    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User("Gysel",23);
        User user2 = new User("Gysel",23);
        System.out.println(user2.equals(user1));
        System.out.println(user1);

        User clone = (User) user1.clone();
        System.out.println(clone.equals(user1));
        System.out.println(clone==user1);
    }
}
