package april.concurrent.sync.queue;

import org.openjdk.jol.info.ClassLayout;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 消息队列demo
 *
 * @author yanzx
 */
public class Client {
    public static void main(String[] args) {
        Queue<String> msgs = new LinkedList<>();
        Product product = new Product(msgs, 5);
        Customer customer = new Customer(msgs, 5);
        System.out.println(ClassLayout.parseInstance(msgs).toPrintable());
        Thread t1 = new Thread(product);
        Thread t2 = new Thread(customer);
        t1.start();
        t2.start();
    }
}
