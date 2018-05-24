package patternObserver;

import java.util.Observable;

/**
 * 主题 房价
 */
public class HousingPrice extends Observable{

    public void setPrice(String price){
        setChanged();
        notifyObservers(price);
    }
}
