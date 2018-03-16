package singletonpattern.singleton03;

public class SingletonTest {
    private volatile static SingletonTest instance;

    private void SingletonTest() {
    }

    public static SingletonTest getInstance() {
        try {
            Thread.sleep(300);
            if (instance == null) {
                Thread.sleep(300);
                synchronized (Singleton.class) {
                    Thread.sleep(300);
                    if (instance == null) {
                        Thread.sleep(300);
                        instance = new SingletonTest();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
