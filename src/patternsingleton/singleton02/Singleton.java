package patternsingleton.singleton02;

/**
 * 单例设计模式
 * 懒汉式单例 线程不安全
 */
public class Singleton {

    private static Singleton instance;

    private void Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            instance = new Singleton();
        }
        return instance;
    }
}
