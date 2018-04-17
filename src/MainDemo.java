import patternbuilder.MacBook;
import patternsingleton.singleton03.SingletonTest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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

//        for (int j = 0; j < mts.length; j++) {
//            mts[j].start();
//        }
        TestWord testWord = new TestWord();
        TestWord testWord1 = new TestWord();
        TestWord testWord2 = new TestWord();

        System.out.println(testWord);
        System.out.println(testWord1);
        System.out.println(testWord2);

        System.out.println(testWord.mObject);
        System.out.println(testWord1.mObject);
        System.out.println(testWord2.mObject);


        System.out.println(testWord1.getClass().equals(testWord2.getClass()));
        System.out.println("---------------------------------------");

        Person st = new Person<Student>();
        Class clazz = st.getClass();
        //getSuperclass()获得该类的父类
        System.out.println(clazz.getSuperclass());
        //getGenericSuperclass()获得带有泛型的父类
        //Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
        Type type = clazz.getGenericSuperclass();
        System.out.println(type);
        //ParameterizedType参数化类型，即泛型
        ParameterizedType p = (ParameterizedType) type;
        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Class c = (Class) p.getActualTypeArguments()[0];
        System.out.println(c);
    }
}
