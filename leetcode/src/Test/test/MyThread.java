package Test.test;


import java.util.concurrent.*;

class MyThread{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //方法1：继承Thread
        Thread t1 = new Thread(()-> System.out.println("t1线程执行"));
        t1.start();

        //方法2：实现Runable接口
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("t2线程执行");
            }
        };
        Thread t2 = new Thread(r);
        t2.start();

        //实现Callable接口与FutureTask
        FutureTask<Integer> task=new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 666;
            }
        });
        Thread t3 = new Thread(task);
        t3.start();
        System.out.println(task.get());

        //CompletetableFuture
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "执行有返回值的任务");
        future.thenAccept(res-> System.out.println("回调结果："+res));

        //线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.submit(()-> System.out.println("线程池线程"));
        pool.shutdown();  // 关闭线程池
    }
}

