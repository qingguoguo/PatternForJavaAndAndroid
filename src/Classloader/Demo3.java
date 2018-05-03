package Classloader;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();
        //getFields，获取所有修饰符为public的字段，包含父类的字段
        //Field[] fields = studentClass.getFields();
        //getDeclaredFields,获取本类的所有字段包括private修饰的，不包含父类的字段

        Field[] fields = studentClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        Field score = studentClass.getDeclaredField("score");
        System.out.println(score);
        score.setAccessible(true);
        score.set(student, 880);
        System.out.println(student);
        System.out.println("--------------------------------------------");
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("--------------------------------------------");
        Method[] dMethods = studentClass.getDeclaredMethods();
        for (Method method : dMethods) {
            System.out.println(method);
        }

        Method setScore = studentClass.getDeclaredMethod("setScore", int.class);
        setScore.setAccessible(true);
        setScore.invoke(student, 999);
        System.out.println(student);
        System.out.println(setScore.getReturnType());
        System.out.println(setScore.getGenericReturnType());
    }
}
