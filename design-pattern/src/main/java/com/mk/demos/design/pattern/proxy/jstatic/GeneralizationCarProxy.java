package com.mk.demos.design.pattern.proxy.jstatic;

import com.mk.demos.design.pattern.proxy.Car;

/**
 * 使用继承方式对car中move方法进行代理
 *
 * 静态代理：方法一：继承方式
 *
 * 由于使用的是继承方式，所以，所有用到Car的时候，均可以使用GeneralizationCarProxy来代替
 *
 * @author WangChen
 * Created on 2021/1/10 20:00
 * @since 1.0
 */
public class GeneralizationCarProxy extends Car {

    @Override
    public void move() {
        System.out.println("CarGeneralizationProxy start...");
        super.move();
        System.out.println("CarGeneralizationProxy end...");
    }
}
