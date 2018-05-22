package patternsingleton.singleton03;

/**
 * 单例设计模式
 * 懒汉式单例   双重查锁机制
 * http://blog.csdn.net/cselmu9/article/details/51366946
 *
 * volatile 关键字的作用1.可见性 2.禁止指令重排序优化
 *
 * 但是这里用到的是 禁止指令重排序优化
 *
 * 特别注意在 Java 5 以前的版本使用了 volatile 的双检锁还是有问题的。
 * 其原因是 Java 5 以前的 JMM （Java 内存模型）是存在缺陷的，
 * 即时将变量声明成 volatile 也不能完全避免重排序，主要是 volatile 变量前后的代码仍然存在重排序问题。
 * 这个 volatile 屏蔽重排序的问题在 Java 5 中才得以修复，所以在这之后才可以放心使用 volatile。
 */
public class Singleton {
    private volatile static Singleton instance;

    private void Singleton() {
    }

    public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
        return instance;
    }
}
