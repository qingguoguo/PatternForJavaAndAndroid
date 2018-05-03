package Classloader;

public class Person {
    public int age;
    private String name;

    public Person() {
        super();
    }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
