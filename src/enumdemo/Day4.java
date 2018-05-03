package enumdemo;

/**
 * 由于java单继承的原因，enum类并不能再继承其他类
 * 但是并不妨碍实现接口，enum仍然可以实现多接口的
 */
public enum Day4 implements food, sport {
    FOOD,
    Sport;

    @Override
    public void eat() {
        System.out.println("eat....");
    }

    @Override
    public void run() {
        System.out.println("run....");
    }

    //测试
    public static void main(String[] args) {
        Day4.FOOD.run();
        Day4.FOOD.eat();
        Day4.Sport.run();
        Day4.Sport.eat();
        /**
         输出结果:
         F:FIRST TIME
         S:SECOND TIME
         */
    }
}

interface food {
    void eat();
}

interface sport {
    void run();
}