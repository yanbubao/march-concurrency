package april.concurrent.volatilez;

/**
 * @author yanzx
 */
public class VolatileDemo {
    /**
     * volatile在JVM层面会根据不同硬件（CPU架构）和OS去生成不同的"内存屏障指令"
     */
    private volatile int a = 0;
}
