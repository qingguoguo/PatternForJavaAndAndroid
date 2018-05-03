package enumdemo;

/**
 * 有时候，我们可能需要对一组数据进行分类，
 * 比如进行食物菜单分类而且希望这些菜单都属于food类型，
 * appetizer(开胃菜)、mainCourse(主菜)、dessert(点心)、Coffee等，
 * 每种分类下有多种具体的菜式或食品，此时可以利用接口来组织，
 * 如下(代码引用自Thinking in Java)
 */
public class Day5 {
    public interface Food {
        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROLLS;
        }

        enum MainCourse implements Food {
            LASAGNE, BURRITO, PAD_THAI,
            LENTILS, HUMMOUS, VINDALOO;
        }

        enum Dessert implements Food {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE,
            FRUIT, CREME_CARAMEL;
        }

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
            LATTE, CAPPUCCINO, TEA, HERB_TEA;
        }
    }

    /**
     * 同时确保每种具体类型的食物也属于Food，
     * 现在我们利用一个枚举嵌套枚举的方式，
     * 把前面定义的菜谱存放到一个Meal菜单中，
     * 通过这种方式就可以统一管理菜单的数据
     */
    public enum Meal {
        APPETIZER(Food.Appetizer.class),
        MAINCOURSE(Food.MainCourse.class),
        DESSERT(Food.Dessert.class),
        COFFEE(Food.Coffee.class);

        private Food[] foods;

        //构造方法传入枚举数组
        Meal(Class<? extends Food> kind) {
            foods = kind.getEnumConstants();
        }

        public Food[] getFoods() {
            return foods;
        }
    }

    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        System.out.println(food);
        food = Food.MainCourse.LASAGNE;
        System.out.println(food);
        food = Food.Dessert.GELATO;
        System.out.println(food);
        food = Food.Coffee.CAPPUCCINO;
        System.out.println(food);

        System.out.println("----------------------------------------------");
        System.out.println(Meal.APPETIZER);
        System.out.println(Meal.MAINCOURSE);
        System.out.println(Meal.DESSERT);
        System.out.println(Meal.COFFEE);
        System.out.println("----------------------------------------------");
        for (Food food1 : Meal.APPETIZER.getFoods()) {
            System.out.println(food1);
        }
        System.out.println("----------------------------------------------");
    }
}
