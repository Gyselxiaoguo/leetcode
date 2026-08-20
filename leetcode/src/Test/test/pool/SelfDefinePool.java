package Test.test.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SelfDefinePool {
    public static void main(String[] args) {
        // 获取CPU核心数 用于合理设置线程数
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        // 手动配置线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                corePoolSize, // 核心线程数 线程池长期维持的最小线程数
                corePoolSize * 2, // 最大线程数 线程池能容纳的最多线程数
                60L, // 空闲线程存活时间 超过核心线程数的空闲线程 多久后销毁
                TimeUnit.SECONDS, // 存活时间单位
                new ArrayBlockingQueue<>(100), // 任务阻塞队列 核心线程忙时 新任务存这里
                Executors.defaultThreadFactory(), // 线程创建工厂 用于设置线程名 优先级等
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略 队列满且线程数达最大时 如何处理新任务
        );
        // 提交任务的两种方式和之前一致 这里用execute提交Runnable（无返回值 不能捕获异常）
        threadPool.submit(() -> {
            System.out.println("IO任务执行中 " + Thread.currentThread().getName());
        // 模拟IO操作 比如数据库查询 网络请求
        });
        // 关闭线程池 推荐用shutdown 等待已提交任务完成后再关闭
        threadPool.shutdown();
        // 若需要强制关闭 可调用shutdownNow 会中断正在执行的任务 返回未执行的任务
        // List<Runnable> unExecutedTasks = threadPool.shutdownNow();

    }
}
