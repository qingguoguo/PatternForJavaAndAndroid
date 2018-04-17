public class TestWord<T> {
    static Object mObject = new Object();

    int age;
    String name;

    @Override
    public String toString() {
        return "TestWord{" + "age=" + age + ", name='" + name + '\'' + this.hashCode() + '}';
    }
}
