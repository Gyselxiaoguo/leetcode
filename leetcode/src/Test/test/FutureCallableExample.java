package Test.test;

import java.util.concurrent.*;

public class FutureCallableExample {
public static void main(String[] args) throws Exception {
    ExecutorService pool = Executors.newSingleThreadExecutor();

    FutureTask<Integer> f=new FutureTask<>(()->{
        System.out.println(Thread.currentThread().getName() + " 开始执行 Callable 任务");
        Thread.sleep(2000); // 模拟耗时操作
        return 42; // 返回结果
    });
    pool.submit(f); //提交任务

    System.out.println("主线程继续执行其他任务");
    try {
        Integer result = f.get(); // 等待任务完成并获取结果
        System.out.println("任务的结果: " + result);
    } catch (Exception e) {
        e.printStackTrace();
    }
    pool.shutdown();
    }
}