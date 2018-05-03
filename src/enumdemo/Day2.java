package enumdemo;

/**
 * 即使重写了构造方法，仍然无法手动调用构造函数创建枚举实例，只能由编译器执行
 * 只有toString方法没有用final修饰，可重写
 */

public enum Day2 {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private String desc;//中文描述

    Day2(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return desc;
    }

    public static void main(String[] args) {
        for (Day2 day : Day2.values()) {
            //无法手动调用构造函数创建枚举实例，只能由编译器执行 Error:(25, 25) java: 无法实例化枚举类型
            //Day2 day2 = new Day2("df");
            System.out.println("name:" + day.name() + ",desc:" + day.getDesc());
        }
    }
}
