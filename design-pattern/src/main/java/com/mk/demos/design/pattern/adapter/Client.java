package com.mk.demos.design.pattern.adapter;

/**
 * 适配器模式-client
 *
 * 定义：将一个类的接口，转换成客户期望的另一个接口。
 *      这样，适配器就可以让原本接口不兼容的类可以合作。
 *
 * 对象适配器：使用的是组合方式  ？
 * 类适配器：使用的是继承方式    ？
 * 接口适配器：                ？
 *
 *
 * 所谓的目标，是站在使用者client的角度，还是站在适配器adapter的角度 来看的？
 *
 *
 *
 * @author WangChen
 * Created on 2022/6/18
 * @since 1.0.0
 */
public class Client {

    private Target twoHoleCharge;

    public Client(Target twoHoleCharge) {
        this.twoHoleCharge = twoHoleCharge;
    }

    public void charge() {
        twoHoleCharge.twoHoleCharging();
    }
}
