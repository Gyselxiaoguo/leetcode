package Test.test.pool;

import java.util.concurrent.locks.ReentrantLock;

public class AddLock {
    static int count=0;
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                lock.lock();
                count++;
                lock.unlock();
            }
        }, "thread1");


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                lock.lock();
                count++;
                lock.unlock();
            }
        }, "thread2");

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();
        System.out.println("----"+count+"-----");
    }
}
