package com.mk.demos.design.pattern.observer.push;

import java.util.ArrayList;
import java.util.List;

/**
 * 需要观察的主体
 *
 * @author WangChen
 * Created on 2021/9/7 15:29
 * @since 0.1
 */
public class Subject {

    /**
     * 所有的观察者
     */
    private List<Observer> observers = new ArrayList<>();

    public void register(Observer observer){
        this.observers.add(observer);
    }

    public void remove(Observer observer){
        this.observers.remove(observer);
    }

    private void noticeAllObservers(){
        for (Observer observer : observers){
            observer.getNotice();
        }
    }

    /**
     * 状态
     * 当状态发生变动时，所有的观察者会受到变动通知(消息)
     */
    private int state;

    public int getState() {
        return state;
    }

    public void changeState(int state) {
        this.state = state;
        this.noticeAllObservers();
    }
}
