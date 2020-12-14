package april.concurrent.sync;

/**
 * @author yanzx
 */
public class SynchronizedDemo {

    // object lock
    private final Object lock;

    public SynchronizedDemo(Object lock) {
        this.lock = lock;
    }

    public void demo() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        Object object2 = new Object();
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo(object);
        SynchronizedDemo synchronizedDemo2 = new SynchronizedDemo(object);

        new Thread(synchronizedDemo::demo, "thread1").start();
        new Thread(synchronizedDemo2::demo, "thread2").start();
    }
}
