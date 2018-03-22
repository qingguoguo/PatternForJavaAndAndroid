package patternsingleton.singleton03;

/**
 * 可以看出 加volatile关键字标识变量可见性的作用
 *
 * http://blog.csdn.net/cselmu9/article/details/51366946
 */
public class ExampleVolatile extends Thread {

    //这里注意加volatile关键字和不加的运行结果
    //private boolean isRunning = true;
    private volatile boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        System.out.println("进入run方法..");
        int i = 0;
        while (isRunning == true) {//加了volatile标识的变量在主内存中的可见性将发挥作用
            //..
            System.out.println("线程执行中");
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        ExampleVolatile rt = new ExampleVolatile();
        rt.start();
        Thread.sleep(1000);
        rt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
    }
}

