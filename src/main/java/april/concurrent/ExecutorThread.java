package april.concurrent;

import april.concurrent.volatilez.LazyDclSingleton;

/**
 * @author yanzx
 */
public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        LazyDclSingleton instance = LazyDclSingleton.getInstance();

        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}
