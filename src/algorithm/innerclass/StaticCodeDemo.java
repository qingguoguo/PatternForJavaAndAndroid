package algorithm.innerclass;


class People {
    People() {
        System.out.println("父类构造方法");
    }

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }
}

class Student extends People {

    static {
        System.out.println("子类静态代码块");
    }

    Student() {
        System.out.println("子类构造方法");
    }

    {
        System.out.println("子类代码块");
    }
}

public class StaticCodeDemo {
    public static void main(String[] args) {
        Student bar = new Student();
    }
}
