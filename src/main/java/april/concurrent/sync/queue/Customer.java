package april.concurrent.sync.queue;

import java.util.Queue;

/**
 * 消息队列demo
 *
 * @author yanzx
 */
public class Customer implements Runnable {
    private final Queue<String> msgs;
    private int maxSize;

    public Customer(Queue<String> msgs, int maxSize) {
        this.msgs = msgs;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (msgs) {
                if (msgs.isEmpty()) {
                    try {
                        // 阻塞当前线程
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

                System.out.println("消费者消费消息，" + msgs.remove());
                // 唤醒处于阻塞状态下的生产者
                msgs.notify();
            }
        }
    }
}
