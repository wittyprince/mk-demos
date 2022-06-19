package com.mk.demos.design.pattern.observer.jdk;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

/**
 * 观察者B
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class ObserverB implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ConcreteObservable) {
            System.out.println("B 收到的数据: " + arg);
            if (Objects.isNull(arg)) {
                String state = ((ConcreteObservable) o).queryState();
                System.out.println("B 拉取到的数据: " + state);
            }
        }
    }
}
