package Test.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCompletableFuture {
    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行至此");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 66;
        });
        cf.thenAccept(res->{
            System.out.println("回调的结果："+res);
        });
        System.out.println("主线程执行至此");
        Thread.sleep(3000);
    }
}
