package Test.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture future1=CompletableFuture.runAsync(()->{
            System.out.println("执行没有返回值的任务");
        });

        CompletableFuture future2=CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "执行有返回值的任务";
        });

        // 异步回调：任务完成后自动执行，主线程不阻塞
        future2.thenAccept(res -> {
            System.out.println("回调拿到结果：" + res);
        });

        System.out.println("主线程直接走到over，不会阻塞！");
        Thread.sleep(3000); //让主线程睡眠3秒，等待future2
    }
}
