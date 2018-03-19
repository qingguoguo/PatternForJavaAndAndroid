package DemoForEnum;

import java.util.*;

/**
 * 思考这样一个问题，现在我们有一堆size大小相同而颜色不同的数据，
 * 需要统计出每种颜色的数量是多少以便将数据录入仓库，
 * 定义枚举用于表示颜色Color
 * <p>
 * 代码比较简单，我们使用两种解决方案，一种是HashMap，一种EnumMap，虽然都统计出了正确的结果，
 * 但是EnumMap作为枚举的专属的集合，我们没有理由再去使用HashMap，毕竟EnumMap要求其Key必须为Enum类型，
 * 因而使用Color枚举实例作为key是最恰当不过了，也避免了获取name的步骤，更重要的是EnumMap效率更高，
 * 因为其内部是通过数组实现的（稍后分析），注意EnumMap的key值不能为null，虽说是枚举专属集合，
 * 但其操作与一般的Map差不多，概括性来说EnumMap是专门为枚举类型量身定做的Map实现，
 * 虽然使用其它的Map（如HashMap）也能完成相同的功能，但是使用EnumMap会更加高效，
 * 它只能接收同一枚举类型的实例作为键值且不能为null，
 * 由于枚举类型实例的数量相对固定并且有限，所以EnumMap使用数组来存放与枚举类型对应的值，
 * 毕竟数组是一段连续的内存空间，根据程序局部性原理，效率会相当高
 */

enum Color {
    GREEN, RED, HFSHD, BLUE, YELLOW, JIIFHIDS;
}

public class Day7 {

    public static class Clothes {
        private String num;
        private Color color;

        public Clothes(String num, Color color) {
            this.num = num;
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }

    public static void main(String[] args) {
        List<Clothes> list = new ArrayList<>();
        list.add(new Clothes("C001", Color.BLUE));
        list.add(new Clothes("C002", Color.YELLOW));
        list.add(new Clothes("C003", Color.RED));
        list.add(new Clothes("C004", Color.GREEN));
        list.add(new Clothes("C005", Color.BLUE));
        list.add(new Clothes("C006", Color.BLUE));
        list.add(new Clothes("C007", Color.RED));
        list.add(new Clothes("C008", Color.YELLOW));
        list.add(new Clothes("C009", Color.YELLOW));
        list.add(new Clothes("C010", Color.GREEN));
        //方案1:使用HashMap
        Map<String, Integer> map = new HashMap<>();
        for (Clothes clothes : list) {
            String colorName = clothes.getColor().name();
            Integer count = map.get(colorName);
            if (count != null) {
                map.put(colorName, count + 1);
            } else {
                map.put(colorName, 1);
            }
        }
        System.out.println(map.toString());
        System.out.println("-----------------");

        //方案2:使用EnumMap
        Map<Color, Integer> enumMap = new EnumMap<>(Color.class);
        for (Color color : enumMap.keySet()) {
            System.out.println(color);
        }
        System.out.println("-------------------------");
        for (Clothes clothes : list) {
            Color color = clothes.getColor();
            Integer count = enumMap.get(color);
            if (count != null) {
                enumMap.put(color, count + 1);
            } else {
                enumMap.put(color, 1);
            }
        }
        System.out.println(enumMap.toString());
        System.out.println("-------------------------");
        for (Color color : enumMap.keySet()) {
            System.out.println(color);
        }
    }
}