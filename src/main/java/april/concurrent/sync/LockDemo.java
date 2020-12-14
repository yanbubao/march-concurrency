package april.concurrent.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author yanzx
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        // 对象锁
        LockDemo lock = new LockDemo();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 抢占锁");
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            }
        }).start();

        // 主线程
        synchronized (lock) {
            //Thread.sleep(2000);
            System.out.println("Main 抢占锁");
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }

        System.out.println(lock.hashCode());
    }
}
