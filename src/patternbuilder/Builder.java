package patternbuilder;

/**
 * Builder模式
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 * 
 * Builder模式的使用场景
 * 1.相同的方法，不同的执行顺序，产生不同的事件结果时
 * 2.多个部件或零件，都可以装配到的一个对象中，但是产生的运行结果又不相同时
 * 3.产品类非常复杂，或者产品类中的调用顺序不同产生了不同的作用，这个时候使用建造者模式
 * 4.当初始化一个对象特别复杂，如参数多，且很多参数都具有默认值时
 */

public abstract class Builder {

    public abstract void buildBoard(String board);

    public abstract void buildDisplay(String display);

    public abstract void buildOS();

    public abstract Computer create();
}
