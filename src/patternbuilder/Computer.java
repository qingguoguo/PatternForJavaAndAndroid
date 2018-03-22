package patternbuilder;

public abstract class Computer {

    private String mBoard;
    private String mDisplay;
    protected String mOS;

    public void setmBoard(String mBoard) {
        this.mBoard = mBoard;
    }

    public abstract void setmOS();

    public void setmDisplay(String mDisplay) {
        this.mDisplay = mDisplay;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOS='" + mOS + '\'' +
                '}';
    }
}
