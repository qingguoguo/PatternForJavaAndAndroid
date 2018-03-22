package patternbuilder;

public abstract class SimpleBuilder {

    public abstract SimpleBuilder buildBoard(String board);

    public abstract SimpleBuilder buildDisplay(String display);

    public abstract SimpleBuilder buildOS();

    public abstract Computer create();
}
