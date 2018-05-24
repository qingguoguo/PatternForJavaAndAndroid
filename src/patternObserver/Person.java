package patternObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class Person implements Observer {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " 收到了 " + o + " 更新:" + arg);
    }
}
