package algorithm.innerclass;

class Foo {
    int i = 1;

    Foo() {
        System.out.println("父类构造方法");
        System.out.println(i);
        int x = getValue();
        System.out.println(x);
    }

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
        i = 2;
    }

    protected int getValue() {
        System.out.println("父类方法 getValue()：" + i);
        return i;
    }
}

//子类
class Bar extends Foo {
    int j = 1;

    static {
        System.out.println("子类静态代码块");
    }

    Bar() {
        System.out.println("子类构造方法");
        j = 2;
    }

    {
        System.out.println("子类代码块");
        j = 3;
    }

    @Override
    protected int getValue() {
        System.out.println("子类方法 getValue()：" + j);
        return j;
    }
}

public class CodeTestDemo {

    {   // 实例代码块
        System.out.println("代码块1:" + 0);
    }

    private int i = 1;
    private int j = i + 1;

    {   // 实例代码块
        System.out.println("代码块2:" + j + "  " + i);
    }

    public CodeTestDemo(int var) {
        System.out.println("构造方法");
        System.out.println(i);
        System.out.println(j);
        this.i = var;
        System.out.println(i);
        System.out.println(j);
    }

    public static void main(String[] args) {
        Bar bar = new Bar();
        System.out.println("********************************");
        System.out.println(bar.getValue());

        new CodeTestDemo(8);
        int i = -1;
        System.out.println("++i:" + (++i));
    }
}