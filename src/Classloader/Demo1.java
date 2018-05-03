package Classloader;

/**
 * 获取Class对象引用的方式3种，
 * 1.通过继承自Object类的getClass方法，
 * 2.Class类的静态方法forName
 * 3.字面常量的方式”.class”。
 * 其中实例类的getClass方法和Class类的静态方法forName都将会触发类的初始化阶段，
 * 而字面常量获取Class对象的方式则不会触发初始化。
 * <p>
 * 类加载过程：
 * <p>
 * 加载----链接（验证---准备---解析）-----初始化
 * <p>
 * 1.加载，类加载过程的一个阶段：通过一个类的完全限定查找此类字节码文件，
 * 并利用字节码文件创建一个Class对象
 * <p>
 * 2.链接， 验证字节码的安全性和完整性，准备阶段正式为静态域分配存储空间，
 * 注意此时只是分配静态成员变量的存储空间，不包含实例成员变量，如果必要的话，
 * 解析这个类创建的对其他类的所有引用
 * <p>
 * 3.初始化 ，类加载最后阶段，若该类具有超类，则对其进行初始化，执行静态初始化器和静态初始化成员变量
 * <p>
 * 初始化是类加载的最后一个阶段，也就是说完成这个阶段后类也就加载到内存中(Class对象在加载阶段已被创建)，
 * 此时可以对类进行各种必要的操作了（如new对象，调用静态成员等），
 * 注意在这个阶段，才真正开始执行类中定义的Java程序代码或者字节码。
 * <p>
 * 关于类加载的初始化阶段，在虚拟机规范严格规定了有且只有5种场景必须对类进行初始化：
 * <p>
 * 使用new关键字实例化对象时、读取或者设置一个类的静态字段(不包含编译期常量)以及调用静态方法的时候，必须触发类加载的初始化过程(类加载过程最终阶段)。
 * <p>
 * 使用反射包(java.lang.reflect)的方法对类进行反射调用时，如果类还没有被初始化，则需先进行初始化，这点对反射很重要。
 * <p>
 * 当初始化一个类的时候，如果其父类还没进行初始化则需先触发其父类的初始化。
 * <p>
 * 当Java虚拟机启动时，用户需要指定一个要执行的主类(包含main方法的类)，虚拟机会先初始化这个主类
 * <p>
 * 当使用JDK 1.7 的动态语言支持时，如果一个java.lang.invoke.MethodHandle 实例最后解析结果为REF_getStatic、REF_putStatic、REF_invokeStatic的方法句柄，并且这个方法句柄对应类没有初始化时，必须触发其初始化(这点看不懂就算了，这是1.7的新增的动态语言支持，其关键特征是它的类型检查的主体过程是在运行期而不是编译期进行的，这是一个比较大点的话题，这里暂且打住)
 */

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie extends Gum {
    static {
        System.out.println("Loading Cookie");
    }
}

public class Demo1<T> {

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        Class<Cookie> cookieClass = Cookie.class;

        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("Classloader.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Classloader.Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
        System.out.println(int.class);
        System.out.println(Integer.class);
        System.out.println("----------------------------");
        //没有泛型
        Class intClass = int.class;
        //带泛型的Class对象
        Class<Integer> integerClass = int.class;
        integerClass = Integer.class;
        //没有泛型的约束,可以随意赋值
        intClass = double.class;
        //编译期错误,无法编译通过
        //integerClass = double.class;

        Class<?> integerClass1 = int.class;
        integerClass1 = double.class;

        Class<? extends Number> clazz = Integer.class;
        clazz = double.class;
        clazz = Number.class;

        //Cookie extends Gum

        Cookie cook = new Cookie();
        Gum gum = new Gum();

//        Class<Cookie> type = Cookie.class;
//        Cookie cook = type.cast(gum);
        System.out.println("----------------------------");
        System.out.println(gum instanceof Cookie);
        System.out.println(gum instanceof Gum);
        System.out.println(cook instanceof Cookie);
        System.out.println(cook instanceof Gum);


        System.out.println("----------------------------");

        System.out.println(Cookie.class.isInstance(cook));
        System.out.println(Gum.class.isInstance(cook));
        System.out.println(Cookie.class.isInstance(gum));
        System.out.println(Gum.class.isInstance(gum));


    }
}
