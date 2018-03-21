package LoadClass;

import java.lang.reflect.Array;

public class Demo4 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 4, 5, 5, 10};
        Class<?> componentType = arr.getClass().getComponentType();

        System.out.println(componentType);
        System.out.println(arr.getClass().isArray());
        System.out.println(Array.getLength(arr));

        Object newArr = Array.newInstance(componentType, 80);
        System.arraycopy(arr, 0, newArr, 0, 5);


        Array.set(newArr, 79, 10000);
        Array.set(newArr, 78, 500);
        Array.setInt(newArr, 77, 5333);
        for (int i : ((int[]) newArr)) {
            System.out.println(i);
        }

        System.out.println(Array.get(newArr, 78));
        String[] strings = {"A", "B", "C", "D", "R", "D"};

        minCopyArray(strings);
    }

    //extends Comparable<T>
    public static <T extends Comparable<T>> void minCopyArray(T[] a) {
        //通过反射创建相同类型的数组
        T[] b = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length);
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        T min = null;
        boolean flag = true;
        for (int i = 0; i < b.length; i++) {
            if (flag) {
                min = b[i];
                flag = false;
            }
            if (b[i].compareTo(min) < 0) {
                min = b[i];
            }
        }
        System.out.println(min);
    }
}
