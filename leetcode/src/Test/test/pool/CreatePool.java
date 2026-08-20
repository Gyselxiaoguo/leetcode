package Test.test.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreatePool {
    public static void main(String[] args) {
        // 创建固定3个线程的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        // 提交Runnable任务 无返回值
        for (int i = 0; i < 5; i++) {
            int taskNum = i;
            fixedThreadPool.submit(() -> {
                System.out.println("当前线程 " + Thread.currentThread().getName() + " 处理任务 " + taskNum);
                try {
                    Thread.sleep(1000); // 模拟任务执行耗时
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        // 提交Callable任务 有返回值
        Future<Integer> future = fixedThreadPool.submit(() -> {
            Thread.sleep(500);
            return 100 + 200; // 任务返回结果
        });
        // 获取Callable任务的返回值 会阻塞直到任务完成
        try {
            Integer result = future.get();
            System.out.println("任务返回结果: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 任务执行完后关闭线程池 避免资源泄露
        fixedThreadPool.shutdown();
    }
}
