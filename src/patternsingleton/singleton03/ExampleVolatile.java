package patternsingleton.singleton03;

/**
 * 可以看出 加volatile关键字标识变量可见性的作用
 */
public class ExampleVolatile extends Thread {

    //这里注意加volatile关键字和不加的运行结果
    private boolean isRunning = true;
    //private volatile boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run方法..");
        while (isRunning) {//加了volatile标识的变量在主内存中的可见性将发挥作用
            //..
            System.out.println("线程执行中");
        }
        System.out.println("线程停止");
        System.out.println("时间：" + (System.currentTimeMillis() - start));
    }

    static long start;

    public static void main(String[] args) throws InterruptedException {
        ExampleVolatile rt = new ExampleVolatile();
        rt.start();
        start = System.currentTimeMillis();
        Thread.sleep(3000);
        rt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
    }
}

