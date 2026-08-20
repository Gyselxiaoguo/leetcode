package Test.test.pool;

import java.util.concurrent.CountDownLatch;

public class ConcurrentExecution {
    public static void main(String[] args) throws InterruptedException {
        int threadCount=3;
        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" running");
                try {
                    Thread.sleep((long) (Math.random()*5000));
                    System.out.println(Thread.currentThread().getName()+" finish");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    latch.countDown();
                }

            },"thread-"+(i+1)).start();
        }

        latch.await();
        System.out.println("all finish");

        new Thread(()->{
            System.out.println("其他任务running...");
        }).start();
    }
}
