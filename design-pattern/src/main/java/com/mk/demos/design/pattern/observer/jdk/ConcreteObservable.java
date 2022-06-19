package com.mk.demos.design.pattern.observer.jdk;

import java.util.Observable;

/**
 * 具体的可被观察的类(对象)
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class ConcreteObservable extends Observable {

    /**
     * 被观察者的内部的数据：状态...
     */
    private String state = "initial";

    /**
     * 用于pull模式下, 观察者来主动获取数据
     */
    public String queryState() {
        return this.state;
    }

    /**
     * 提供接口，可以接收外部参数以改变数据
     */
    public void changeState(String state) {
        this.state = state;
        this.change(state);
    }

    /**
     * 标记方法，表明数据变更了，需要观察者来拉pull数据
     * 具体的变更渠道可能来自：手动更改; 线下更改等
     */
    public void changeState() {
        this.change();
    }


    /**
     * 如果调用的是 notifyObservers() 无参方法，
     * 则需要观察者来拉去数据，为pull模式
     */
    private void change() {
        super.setChanged();
        super.notifyObservers();
    }

    /**
     * 如果调用的是 notifyObservers(arg) 有参方法
     * 则是直接把arg数据推送给了观察者，是push模式
     * @param arg 需要推送的参数
     */
    private void change(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }
}
