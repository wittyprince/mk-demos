package com.mk.demos.design.pattern.observer.push;

/**
 * 具体的观察者1
 *
 * @author WangChen
 * Created on 2021/9/7 15:38
 * @since 0.1
 */
public class Observer1 implements Observer{

    @Override
    public void getNotice() {
        System.out.println("Observer1 receive notice.");
    }


}
