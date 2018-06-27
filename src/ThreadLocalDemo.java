import algorithm.innerclass.InnerClassDemo;

import java.util.concurrent.*;

/**
 * 深入分析 ThreadLocal 内存泄漏问题:https://blog.csdn.net/wudiyong22/article/details/52141608
 */
public class ThreadLocalDemo implements Runnable {


    public String name;

    public ThreadLocalDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
        ExecutorService threadPool = Executors.newScheduledThreadPool(3);
        threadPool.execute(new ThreadLocalDemo("任务1"));
        threadPool.execute(new ThreadLocalDemo("任务2"));
        threadPool.execute(new ThreadLocalDemo("任务3"));
        threadPool.execute(new ThreadLocalDemo("任务4"));
        threadPool.execute(new ThreadLocalDemo("任务5"));
        threadPool.execute(new ThreadLocalDemo("任务6"));
        threadPool.shutdown();

    }
}
