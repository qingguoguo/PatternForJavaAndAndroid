public class ThreadDemo {
    public static void main(String args[]) throws InterruptedException {
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(getName()+":"+i);
//                }
//            }
//        };
//        thread.setName("线程1");
//        thread.start();
//        System.out.println("main方法所在线程名字是 ："+Thread.currentThread().getName());

        //Thread 是实现了 Runnable接口
        //Thread带参构造  Runnable是接口，且只有一个run()方法
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        thread.start();
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.setName("线程1");
        thread2.setName("线程2");
        //设置线程为守护线程
        thread1.setDaemon(true);
        //设置线程为守护线程
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        //判断线程是否为守护线程
        thread1.isDaemon();
        thread2.isDaemon();
        //获取线程优先级
        thread1.getPriority();
        //设置线程优先级
        thread2.setPriority(8);

        //中断线程
        thread1.interrupt();
        thread2.interrupt();

//        synchronized (new Object()){
//            ...
//        }

        try {
            //线程休眠1秒
            thread1.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            //            //线程加入 等待该线程终止,才执行其他线程
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //线程礼让 暂停当前正在执行的线程对象，并执行其他线程
        thread1.yield();
        thread1.getThreadGroup();
    }
}
 class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}