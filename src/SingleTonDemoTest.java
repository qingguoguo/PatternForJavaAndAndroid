import patternsingleton.singleton02.Singleton;
import patternsingleton.singleton03.SingletonTest;

public class SingleTonDemoTest extends Thread{

    @Override
    public void run() {
        System.out.println(SingletonTest.getInstance().hashCode());
    }

    public static void main(String[] args) {

        SingleTonDemoTest[] mts = new SingleTonDemoTest[100];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = new SingleTonDemoTest();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }
}
