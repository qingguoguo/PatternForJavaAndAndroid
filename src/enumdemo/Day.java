package enumdemo;

/**
 * 枚举类型 http://blog.csdn.net/javazejian/article/details/71333103
 *
 * 使用关键字 enum 与classs关键字类似 也可以定义在类的内部
 * 枚举类型Day中定义了从周一到周日的值，值一般大写，多个值逗号隔开
 * 枚举常量在类型安全性和便捷性都很有保证，但是 枚举表示的类型取值是有限的
 *
 * 枚举实现原理
 * 使用关键字enum创建枚举类型编译后，编译器会生成一个相关的类，这个类继承了
 * java api中的java.lang.enum类
 *
 * 反编译生成的Day.class文件
 *
 * 从反编译的代码可以看出编译器确实帮助我们生成了一个Day类(该类是final类型的，将无法被继承)
 * 而且该类继承自java.lang.Enum类（抽象类）
 * 除此之外，编译器还帮助我们生成了7个Day类型的实例对象分别对应枚举中定义的7个日期，
 * 这也充分说明了我们前面使用关键字enum定义的Day类型中的每种日期枚举常量也是实实在在的Day实例对象，
 * 只不过代表的内容不一样而已。编译器还为我们生成了两个静态方法，分别是values()和 valueOf()，
 *
 * 使用关键字enum定义的枚举类型，在编译期后，
 * 也将转换成为一个实实在在的类，而在该类中，会存在每个在枚举类型中定义好变量的对应实例对象，
 * 如上述的MONDAY枚举类型对应public static final Day MONDAY;，同时编译器会为该类创建两个方法，
 * 分别是values()和valueOf()，到此相信我们对枚举的实现原理也比较清晰，
 */
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
