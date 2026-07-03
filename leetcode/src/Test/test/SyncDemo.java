package Test.test;

public class SyncDemo {
    // 同步普通方法：锁this
    public static synchronized void normalMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " 进入对象锁方法");
            Thread.sleep(2000); // 模拟业务耗时
            System.out.println(Thread.currentThread().getName() + " 退出对象锁方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 创建两个独立实例
        SyncDemo obj1 = new SyncDemo();
        SyncDemo obj2 = new SyncDemo();

        // 线程1操作obj1
        new Thread(() -> obj1.normalMethod(), "线程A").start();
        // 线程2操作obj2
        new Thread(() -> obj2.normalMethod(), "线程B").start();
    }
}