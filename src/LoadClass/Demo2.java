package LoadClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class Demo2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<? extends Person> personClass = Person.class;
        Person person = personClass.newInstance();
        person.setName("哈哈哈大富豪");
        System.out.println(person);
        System.out.println("--------------------------------------------");

        //获取public权限构造函数数组
        Constructor<?>[] constructors = personClass.getConstructors();
        //获取所有构造函数的数组
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("--------------------------------------------");

        for (int i = 0; i < declaredConstructors.length; i++) {
            Class<?>[] parameterTypes = declaredConstructors[i].getParameterTypes();
            System.out.println("第" + i + "个构造函数：" + declaredConstructors[i]);
            System.out.println("第" + i + "个构造函数：" + declaredConstructors[i].getName());
            System.out.print("参数类型:[" + i + "]:(");

            for (int j = 0; j < parameterTypes.length; j++) {
                if (j == parameterTypes.length - 1) {
                    System.out.print(parameterTypes[j] + ")");
                } else {
                    System.out.print(parameterTypes[j] + ",");
                }
            }
            System.out.println(")");
        }

        System.out.println("--------------------------------------------");
        Constructor<? extends Person> constructor = personClass.getConstructor(String.class);
        Person person1 = constructor.newInstance("ddfdssfs");
        System.out.println(person1);
        System.out.println(constructor);
        System.out.println("--------------------------------------------");
        Constructor<? extends Person> constructor1 = personClass.getDeclaredConstructor(String.class, int.class);
        constructor1.setAccessible(true);
        Person fdfdasr = constructor1.newInstance("啥哈哈哈", 10);
        System.out.println(constructor1);
        System.out.println(fdfdasr);
        System.out.println("--------------------------------------------");

        Constructor cs3 = personClass.getDeclaredConstructor(String.class, int.class);

        System.out.println("-----getDeclaringClass-----");
        Class uclazz = cs3.getDeclaringClass();
        //Constructor对象表示的构造方法的类
        System.out.println("构造方法的类:" + uclazz.getName());

        System.out.println("-----getGenericParameterTypes-----");
        //对象表示此 Constructor 对象所表示的方法的形参类型
        Type[] tps = cs3.getGenericParameterTypes();
        for (Type tp : tps) {
            System.out.println("参数名称tp:" + tp);
        }
        System.out.println("-----getParameterTypes-----");
        //获取构造函数参数类型
        Class<?> clazzs[] = cs3.getParameterTypes();
        for (Class claz : clazzs) {
            System.out.println("参数名称:" + claz.getName());
        }
        System.out.println("-----getName-----");
        //以字符串形式返回此构造方法的名称
        System.out.println("getName:" + cs3.getName());

        System.out.println("-----getoGenericString-----");
        //返回描述此 Constructor 的字符串，其中包括类型参数。
        System.out.println("getoGenericString():" + cs3.toGenericString());

    }
}
