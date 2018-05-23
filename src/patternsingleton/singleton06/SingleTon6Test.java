package patternsingleton.singleton06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SingleTon6Test {

    private static final Singleton06<M> gDefault = new Singleton06<M>() {
        @Override
        protected M create() {
            return new M();
        }
    };

    static public M getDefault() {
        return gDefault.getInstance();
    }

    static class M {
        private M() {
        }
    }

    public static void main(String[] args) {
// 创建List集合对象
// 创建List集合对象
        List list = new ArrayList();
// 添加元素
        list.add("hello");
        list.add("world");
        list.add("java");

// 迭代器遍历
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            String s = (String) it.next();
//            if ("world".equals(s)) {
//                list.add("javaee");
//            }
//        }

// 方式1：迭代器迭代元素，迭代器修改元素
// 而Iterator迭代器却没有添加功能，所以我们使用其子接口ListIterator
//        ListIterator lit = list.listIterator();
//        while (lit.hasNext()) {
//            String s = (String) lit.next();
//            if ("world".equals(s)) {
//                lit.add("javaee");
//            }
//        }

// 方式2：集合遍历元素，集合修改元素(普通for)
//        for (int x = 0; x < list.size(); x++) {
//            String s = (String) list.get(x);
//            System.out.println("list:" + list.get(x) + " X:" + x);
//            if ("world".equals(s)) {
//                list.remove("world");
//                list.equals()
//            }
//        }
//
//        System.out.println("list:" + list);
   }
}
