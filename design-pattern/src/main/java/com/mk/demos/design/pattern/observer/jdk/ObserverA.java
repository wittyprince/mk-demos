package com.mk.demos.design.pattern.observer.jdk;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

/**
 * 观察者A
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class ObserverA implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ConcreteObservable) {
            System.out.println("A 收到的数据: " + arg);

            // Objects.isNull(arg) 也可不加判断，直接去拉取pull, 即调用queryState查询
            if (Objects.isNull(arg)) {
                String state = ((ConcreteObservable) o).queryState();
                System.out.println("A 拉取到的数据: " + state);
            }
        }
    }
}
