package com.mk.demos.design.pattern.adapter;

/**
 * 适配器模式-适配器
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void twoHoleCharging() {
        adaptee.threeHoleCharging();
    }
}
