package DemoForEnum;

/**
 * enum类允许我们为其定义抽象方法，
 * 使每个枚举实例都实现该方法，以便产生不同的行为方式
 * 但是 枚举类里定义抽象方法时
 * 不能使用abstract关键字将枚举类定义成抽象类
 * 因为系统自动会添加abastract
 * enum类的实例似乎表现出了多态的特性
 * 可惜的是枚举类型的实例终究不能作为类型传递使用，就像下面的使用方式，编译器是不可能答应的：
 * 无法通过编译,毕竟EnumDemo3.FIRST是个实例对象
 * void text(EnumDemo3.FIRST instance){}
 */
public enum Day3 {
    FIRST {
        @Override
        public String getInfo() {
            return "FIRST TIME";
        }
    },

    Mondfh {
        @Override
        public String getInfo() {
            return "jdfkdjjfddf";
        }
    },

    fddfd {
        @Override
        public String getInfo() {
            return "dfdsfd dfd";
        }
    },

    SECOND {
        @Override
        public String getInfo() {
            return "SECOND TIME";
        }
    };

    /**
     * 定义抽象方法
     */
    public abstract String getInfo();

    //测试
    public static void main(String[] args) {
        System.out.println("F:" + Day3.FIRST.getInfo());
        System.out.println("S:" + Day3.SECOND.getInfo());
        System.out.println("D:" + Day3.fddfd.getInfo());
        System.out.println("F:" + Day3.Mondfh.getInfo());
        /**
         输出结果:
         F:FIRST TIME
         S:SECOND TIME
         */
    }
}
