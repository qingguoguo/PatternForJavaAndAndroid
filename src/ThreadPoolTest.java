import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final int KEEP_ALIVE_SECONDS = 30;

    public static final Executor THREAD_POOL_EXECUTOR;

    //队列
    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(10);
    //BlockingQueue;先进先出队列
    //SynchronousQueue;线程安全的队列，它里面是没有固定的缓存队列 OKHttp
    //PriorityBlockingQueue;无序的可以根据优先级进行排序 指定的对象要实现Comparable比较器

    static {
        final AtomicInteger mCount = new AtomicInteger(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,
                10,
                60,
                TimeUnit.SECONDS,
                sPoolWorkQueue,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "ThreadFactory create " + mCount.getAndIncrement());
                    }
                });

        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    public static void main(String args[]) {
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("下载图片：" + Thread.currentThread().getName());
                }
            };
            THREAD_POOL_EXECUTOR.execute(runnable);
        }
    }
}
