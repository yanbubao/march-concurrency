package april.concurrent.volatilez;

import april.concurrent.ExecutorThread;

/**
 * idea线程模式debug无法验证
 * 无volatile情况下DCL存在的问题
 * <p>
 * DCL问题原因：
 * 在Java中创建一个对象赋值给引用变量需要3步骤，
 * 1、创建一个引用变量
 * 2、在堆中分配空间，创建对象实例
 * 3、把该对象实例内存空间的物理地址返回给引用变量
 * 场景，然而第2步和第3步容易发生顺序颠倒，这就会导致ThreadB拿到了一个只有物理地址但没有对象实例的instance（半对象），而ThreadA还未创建对象实例。最终ThreadB出现错误。
 *
 * @author yanzx
 */
public class LazyDclSingleton {
    private LazyDclSingleton() {
    }

    private static LazyDclSingleton instance;

    public static LazyDclSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDclSingleton.class) {
                if (instance == null) {
                    instance = new LazyDclSingleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecutorThread(), "t1");
        Thread t2 = new Thread(new ExecutorThread(), "t2");

        t1.start();
        t2.start();
    }
}
