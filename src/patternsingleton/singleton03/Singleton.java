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
 *
 * 无序写入：
 为解释该问题，需要重新考察上述清单中的 //3 行。此行代码创建了一个 Singleton 对象并初始化变量 instance 来引用此对象。这行代码的问题是：在 Singleton 构造函数体执行之前，变量 instance 可能成为非 null 的，即赋值语句在对象实例化之前调用，此时别的线程得到的是一个还会初始化的对象，这样会导致系统崩溃。
 什么？这一说法可能让您始料未及，但事实确实如此。在解释这个现象如何发生前，请先暂时接受这一事实，我们先来考察一下双重检查锁定是如何被破坏的。假设代码执行以下事件序列：

 1、线程 1 进入 getInstance() 方法。
 2、由于 instance 为 null，线程 1 在 //1 处进入 synchronized 块。
 3、线程 1 前进到 //3 处，但在构造函数执行之前，使实例成为非 null。
 4、线程 1 被线程 2 预占。
 5、线程 2 检查实例是否为 null。因为实例不为 null，线程 2 将 instance 引用返回给一个构造完整但部分初始化了的 Singleton 对象。
 6、线程 2 被线程 1 预占。
 7、线程 1 通过运行 Singleton 对象的构造函数并将引用返回给它，来完成对该对象的初始化。

 为展示此事件的发生情况，假设代码行 instance =new Singleton(); 执行了下列伪代码：
 mem = allocate();             //为单例对象分配内存空间.
 instance = mem;               //注意，instance 引用现在是非空，但还未初始化
 ctorSingleton(instance);    //为单例对象通过instance调用构造函数

 这段伪代码不仅是可能的，而且是一些 JIT 编译器上真实发生的。执行的顺序是颠倒的，但鉴于当前的内存模型，这也是允许发生的。JIT 编译器的这一行为使双重检查锁定的问题只不过是一次学术实践而已。
 *
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
