package Test.test;

import java.util.concurrent.ThreadPoolExecutor;

public class Test12 {
    private static volatile boolean running=true;
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            while (running){
                System.out.println("Thread is running!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("发生异常了");
                    running=false;
                }
            }
        });
        t.start();

        Thread.sleep(2000);
        t.interrupt();//打标记，引发抛异常

    }
}
