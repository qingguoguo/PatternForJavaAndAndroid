package patternbuilder;

public class Director {

    private Builder mBuilder = null;

    public Director(Builder mBulider) {
        this.mBuilder = mBulider;
    }

    public void construct(String board, String display) {
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }
}
