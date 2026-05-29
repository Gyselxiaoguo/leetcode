package lock.pessimistic;

public class PessimisticLockTest {
    public static void main(String[] args) {
        // 同一个抢购对象，保证锁生效
        PanicBuy shop = new PanicBuy();

        // 模拟 200 个用户同时抢购
        for (int i = 1; i <= 200; i++) {
            new Thread(() -> {
                shop.buyGoods();
            }, "用户" + i).start();
        }
    }
}
/**
 * 商品抢购 - 悲观锁实现
 * 悲观锁：直接加独占锁，同一时间只允许一个线程修改库存
 */
class PanicBuy {
    // 总商品库存：100个
    private static int stock = 100;

    /**
     * 抢购方法：synchronized 就是Java最典型的悲观锁
     */
    public synchronized void buyGoods() {
        // 有库存才抢购
        if (stock > 0) {
            stock--;
            System.out.println(Thread.currentThread().getName()
                    + " 抢购成功，剩余库存：" + stock);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " 抢购失败，商品已抢完");
        }
    }

    // 获取剩余库存
    public int getStock() {
        return stock;
    }
}