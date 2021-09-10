package com.mk.demos.design.pattern.observer.push;

/**
 * 具体的观察者2
 *
 * @author WangChen
 * Created on 2021/9/7 15:39
 * @since 0.1
 */
public class Observer2 implements Observer{

    @Override
    public void getNotice() {
        System.out.println("Observer2 receive notice.");
    }
}
