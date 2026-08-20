package Test.test.pool;

public class PrintOddEven {
private static final Object lock = new Object();
private static int count = 1;
private static final int MAX_COUNT = 10;

    /**
     * 多线程打印奇偶数，怎么控制打印的顺序
     * @param args
     */
    public static void main(String[] args) {
    new Thread(()->{
        synchronized (lock){
            while (count<=MAX_COUNT){
                if(count%2==1){
                    System.out.println(Thread.currentThread().getName()+count);
                    count++;
                    lock.notify();  //唤醒等待线程
                }else {
                    try {
                        lock.wait();    //等待线程，并释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    },"oddThread").start();
    new Thread(()->{
        synchronized (lock){
            while (count<=MAX_COUNT){
                if(count%2==0){
                    System.out.println(Thread.currentThread().getName()+count);
                    count++;
                    lock.notify();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    },"evenThread").start();
    }
}
