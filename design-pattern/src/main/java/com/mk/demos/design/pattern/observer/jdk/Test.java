package com.mk.demos.design.pattern.observer.jdk;

/**
 * 测试类
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        ObserverA a = new ObserverA();
        ObserverB b = new ObserverB();


        ConcreteObservable observable = new ConcreteObservable();
        observable.addObserver(a);
        observable.addObserver(b);

        observable.changeState();

        observable.changeState("push");

        observable.changeState();



    }
}
