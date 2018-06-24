import algorithm.innerclass.InnerClassDemo;

public class ThreadLocalDemo {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalDemo test = new ThreadLocalDemo();

        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        System.out.println("***************************");
        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();
        System.out.println("***************************");
        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
