package Test.test;

public class StopThreadByReturn{
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while (true) {
                // 检测当前线程中断标记，不清除标记
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("检测到中断标记，线程return退出");
                    return; // 直接结束run方法，线程终止
                }
                System.out.println("线程正在运行...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        Thread.sleep(2000);
        // 给线程设置中断标记
        t.interrupt();
    }
}