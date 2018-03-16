import singletonpattern.singleton03.SingletonTest;

public class MainDemo extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(SingletonTest.getInstance().hashCode());
    }

    public static void main(String[] args) {
        MainDemo[] mts = new MainDemo[100];
        for (int i = 0; i < mts.length; i++) {
            mts[i] = new MainDemo();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }
}
