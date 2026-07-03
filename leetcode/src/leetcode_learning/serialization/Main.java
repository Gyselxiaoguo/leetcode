package leetcode_learning.serialization;

import java.io.*;

/**
 * java默认的序列化
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1. 序列化：对象写入 person.dat 文件
        Person person = new Person("Gysel");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"));//输出文件
        oos.writeObject(person);
        System.out.println("序列化完成，已将对象写入文件");


        // 2. 反序列化：从文件读取对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"));
        // 读取并强转为Person
        Person restoredPerson = (Person) ois.readObject();
        System.out.println("反序列化成功，读取到对象：" + restoredPerson);
        restoredPerson.sayHello();

    }
}

// 标记接口：开启Java序列化能力
class Person implements Serializable {
    // 序列化版本号（建议手动定义，避免类修改后反序列化失败）
    private static final long serialVersionUID = 1L;

    private String name;

    // 无参构造（反序列化底层会用到，建议保留）
    public Person() {
    }

    // 有参构造
    public Person(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    // 示例业务方法
    public void sayHello() {
        System.out.println("Hello, " + name);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}
