package enumdemo;

/**
 * 使用switch进行条件判断时，条件参数一般只能是整型，字符型。
 * 而枚举型确实也被switch所支持，
 * 在java 1.7后switch也对字符串进行了支持。
 * 这里我们简单看一下switch与枚举类型的使用：
 */
public enum Day6 {
    ;

    public static void printName(Color color) {
        switch (color) {
            case BLUE: //无需使用Color进行引用
                System.out.println("蓝色");
                break;
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
        }
    }

    public static void main(String[] args) {
        printName(Color.BLUE);
        printName(Color.RED);
        printName(Color.GREEN);
    }

    enum Color {GREEN, RED, BLUE}
}
