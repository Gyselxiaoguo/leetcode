package design_mode.singleton;

public class SingletonPattern {
    public static void main(String[] args) {
    }
}

//饿汉式：类加载时进行实例化
class Singleton1{
    private static Singleton1 singleton=new Singleton1();
    public Singleton1(){}
    public static Singleton1 getInstance(){
        return singleton;
    }
}

//懒汉式：类加载并调用方法才进行实例化
class Singleton2 {
    private static Singleton2 singleton;
    public Singleton2(){}
    public static synchronized Singleton2 getInstance(){
        if(singleton==null){
            singleton=new Singleton2();
        }
        return singleton;
    }
}

//懒汉式的双重检查锁
class Singleton3 {
    private volatile static Singleton3 singleton;   //volatile:防止指令重排，解决 new Singleton3() 的三步操作乱序问题
    public Singleton3(){}
    public static Singleton3 getInstance(){
        if(singleton==null){    //只有第一次创建对象时才会进入同步代码块
            synchronized (Singleton3.class){    //防止多线程同时进入内层，创建多个对象
                if(singleton==null){    //防止阻塞排队的线程，等锁释放后重复创建实例
                    singleton=new Singleton3();
                }
            }
        }
        return singleton;
    }
}