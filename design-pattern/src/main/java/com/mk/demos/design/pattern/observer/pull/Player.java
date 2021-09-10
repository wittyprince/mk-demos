package com.mk.demos.design.pattern.observer.pull;

import com.mk.demos.design.pattern.observer.push2.LightEffectController;
import com.mk.demos.design.pattern.observer.push2.Observable;
import com.mk.demos.design.pattern.observer.push2.Observer;
import com.mk.demos.design.pattern.observer.push2.SoundEffectController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangChen
 * Created on 2021/9/8 9:17
 * @since 0.1
 */
public class Player implements Observable {

    private String name;
    private Integer xCooridinate = 0;
    private Integer yCooridinate = 0;

    private List<Observer> observers ;

    public Player(String name) {
        this.name = name;
        this.observers=new ArrayList();
    }


    public Integer getxCooridinate() {
        return xCooridinate;
    }

    public Integer getyCooridinate() {
        return yCooridinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void moveForward(Integer steps){
        xCooridinate+=steps;
        notifyObservers();
    }

    public void moveBackward(Integer steps){
        xCooridinate-=steps;
        notifyObservers();
    }

    public void jump(Integer height){
        yCooridinate+=height;
        notifyObservers();
    }

    public void fallTo(Integer height){
        yCooridinate=height;
        notifyObservers();
    }

    //This is the core function that delegates the change in the state of the
    //Observable object to the observers
    public void notifyObservers() {
        for(Observer o:observers){
            o.update(this);
        }
    }

    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }
}
