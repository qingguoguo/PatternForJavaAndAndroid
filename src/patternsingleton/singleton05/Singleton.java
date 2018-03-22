package patternsingleton.singleton05;

/**
 * 单例设计模式
 * 枚举单例模式
 * 用枚举写单例实在太简单了！这也是它最大的优点。
 * Singleton.INSTANCE来访问实例，这比调用getInstance()方法简单多了。
 * 创建枚举默认就是线程安全的，所以不需要担心double checked locking，
 * 而且还能防止反序列化导致重新创建新的对象。
 * <p>
 * 枚举序列化是由jvm保证的，每一个枚举类型和定义的枚举变量在JVM中都是唯一的，
 * 在枚举类型的序列化和反序列化上，
 * Java做了特殊的规定：在序列化时Java仅仅是将枚举对象的name属性输出到结果中，
 * 反序列化的时候则是通过java.lang.Enum的valueOf方法来根据名字查找枚举对象。
 * 同时，编译器是不允许任何对这种序列化机制的定制的并禁用了
 * writeObject、readObject、readObjectNoData、writeReplace和readResolve等方法，
 * 从而保证了枚举实例的唯一性
 */
public enum Singleton {
    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
