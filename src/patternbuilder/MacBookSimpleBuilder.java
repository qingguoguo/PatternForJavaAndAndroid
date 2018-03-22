package patternbuilder;

public class MacBookSimpleBuilder extends SimpleBuilder {

    private Computer mComputer = new MacBook();

    @Override
    public SimpleBuilder buildBoard(String board) {
        mComputer.setmBoard(board);
        return this;
    }

    @Override
    public SimpleBuilder buildDisplay(String display) {
        mComputer.setmDisplay(display);
        return this;
    }

    @Override
    public SimpleBuilder buildOS() {
        mComputer.setmOS();
        return this;
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
