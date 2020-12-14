package april.concurrent.sync.queue;

import java.util.Queue;

/**
 * 消息队列demo
 *
 * @author yanzx
 */
public class Product implements Runnable {
    private final Queue<String> msgs;
    private int maxSize;

    public Product(Queue<String> msgs, int maxSize) {
        this.msgs = msgs;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            synchronized (msgs) {
                while (msgs.size() == this.maxSize) {
                    try {
                        // 释放锁
                        msgs.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // for show
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("生产者生产消息，" + i);
                msgs.add("生产消息，" + i);
                // 唤醒处于阻塞状态下的消费者
                msgs.notify();
                msgs.notifyAll();
            }
        }
    }
}
