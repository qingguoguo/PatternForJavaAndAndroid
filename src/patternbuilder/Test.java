package patternbuilder;

public class Test {
    public static void main(String[] args) {

        MacBookBuilder macBookBuilder = new MacBookBuilder();
        Director director = new Director(macBookBuilder);
        director.construct("英特尔主板", "27寸屏幕");
        System.out.println("电脑信息：" + macBookBuilder.create());

        System.out.println("----------------------------------");

        MacBookSimpleBuilder macBookSimpleBuilder = new MacBookSimpleBuilder();
        macBookSimpleBuilder.buildBoard("惠普主板")
                .buildDisplay("30寸屏幕")
                .buildOS();
        System.out.println("电脑信息：" + macBookSimpleBuilder.create());
    }
}
