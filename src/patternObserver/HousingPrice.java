package patternObserver;

import java.util.Observable;

/**
 * 主题 房价
 */
public class HousingPrice extends Observable{

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
