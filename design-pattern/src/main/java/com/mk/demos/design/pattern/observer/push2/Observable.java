package com.mk.demos.design.pattern.observer.push2;

/**
 * @author WangChen
 * Created on 2021/9/8 9:18
 * @since
 */
public interface Observable {

    public void notifyObservers();
    public void addObserver(Observer o);
    public void removeObserver(Observer o);

}
