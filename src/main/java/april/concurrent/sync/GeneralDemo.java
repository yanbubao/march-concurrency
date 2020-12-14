package april.concurrent.sync;

/**
 * eg.
 * 结果是小于等于1000的随机数
 * 原因： 可见性、原子性
 *
 * @author yanzx
 */
public class GeneralDemo {
    private static int count = 0;

    private static void incr() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(GeneralDemo::incr).start();
        }
        Thread.sleep(3000); //保证线程执行结束
        System.out.println("运行结果：" + count);
    }
}
