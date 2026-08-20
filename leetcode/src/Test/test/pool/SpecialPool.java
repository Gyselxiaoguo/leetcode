package Test.test.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpecialPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }
}
